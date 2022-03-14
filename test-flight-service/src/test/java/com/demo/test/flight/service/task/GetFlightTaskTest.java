package com.demo.test.flight.service.task;

import com.demo.test.flight.domain.service.SampleFlightsService;
import com.demo.test.flight.service.dto.TestFlightInboundDTO;
import com.demo.test.flight.service.enums.Utils;
import com.demo.test.flight.service.helper.TestClassHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetFlightTaskTest {

    @Spy
    @InjectMocks
    private GetFlightTask getFlightTask;

    @Mock
    private SampleFlightsService sampleFlightsService;

    @BeforeEach
    public void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        Mockito.when(sampleFlightsService.findTodayFlights())
                .thenReturn(TestClassHelper.buildFlightsList());
        Mockito.when(sampleFlightsService.findTodayFlights(Mockito.anyString()))
                .thenReturn(TestClassHelper.buildFlightsList());
    }

    @Test
    public void testProcess() {
        Map<String, Object> input = new HashMap<>();
        TestFlightInboundDTO inboundDTO = new TestFlightInboundDTO();

        inboundDTO.setAirlineCode("QF");
        input.put(Utils.REQUEST.toString(), inboundDTO);
        assertNotNull(getFlightTask.process(input));

        inboundDTO.setAirlineCode(null);
        input.put(Utils.REQUEST.toString(), inboundDTO);
        assertNotNull(getFlightTask.process(input));
    }
}
