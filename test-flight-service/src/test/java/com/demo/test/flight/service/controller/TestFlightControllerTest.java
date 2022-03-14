package com.demo.test.flight.service.controller;

import com.demo.test.flight.service.dto.TestFlightInboundDTO;
import com.demo.test.flight.service.helper.TestClassHelper;
import com.demo.test.flight.service.provider.TestFlightProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TestFlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestFlightProvider testFlightProvider;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(testFlightProvider.execute(Mockito.anyMap())).thenReturn(TestClassHelper.buildTestFlightOutboundDTO());
    }

    @Test
    public void testFlight() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.get("/test-app/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new TestFlightInboundDTO()))
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.flightDetails[0].flightNumber").value("QF001"));
    }

    @Test
    public void testFlightException() throws Exception {
        Mockito.when(testFlightProvider.execute(Mockito.anyMap())).thenReturn(new Exception());
        mockMvc.perform(MockMvcRequestBuilders.get("/test-app/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}
