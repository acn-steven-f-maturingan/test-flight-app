package com.demo.test.flight.service.provider;

import com.demo.test.flight.service.dto.TestFlightOutboundDTO;
import com.demo.test.flight.service.enums.Utils;
import com.demo.test.flight.service.task.GetFlightTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestFlightProvider {

    @Autowired
    private GetFlightTask getFlightTask;

    public Object execute(Map<String, Object> input) {
        Map<String, Object> output = new HashMap<>();
        output.putAll(getFlightTask.process(input));
        TestFlightOutboundDTO testFlightOutboundDTO =(TestFlightOutboundDTO) output.get(Utils.RESPONSE.toString());
        return testFlightOutboundDTO;
    }
}
