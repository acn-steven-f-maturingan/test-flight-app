package com.demo.test.flight.service.provider;

import com.demo.test.flight.service.dto.TestFlightOutboundDTO;
import com.demo.test.flight.service.enums.Utils;
import com.demo.test.flight.service.helper.TestClassHelper;
import com.demo.test.flight.service.task.GetFlightTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestFlightProviderTest {

    @Spy
    @InjectMocks
    private TestFlightProvider testFlightProvider;

    @Mock
    private GetFlightTask getFlightTask;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute() throws ParseException {
        Map<String, Object> values = new HashMap<>();
        values.put(Utils.RESPONSE.toString(), TestClassHelper.buildTestFlightOutboundDTO());
        Mockito.when(getFlightTask.process(Mockito.anyMap())).thenReturn(values);
        TestFlightOutboundDTO testFlightOutboundDTO = (TestFlightOutboundDTO) testFlightProvider.execute(values);
        assertNotNull(testFlightOutboundDTO);
    }
}
