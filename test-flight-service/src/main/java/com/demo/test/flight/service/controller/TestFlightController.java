package com.demo.test.flight.service.controller;

import com.demo.test.flight.service.dto.ErrorMessageDTO;
import com.demo.test.flight.service.dto.TestFlightInboundDTO;
import com.demo.test.flight.service.dto.TestFlightOutboundDTO;
import com.demo.test.flight.service.enums.ErrorCode;
import com.demo.test.flight.service.enums.Utils;
import com.demo.test.flight.service.provider.TestFlightProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test-app")
public class TestFlightController {

    @Autowired
    private TestFlightProvider testFlightProvider;

    @GetMapping(path = "/flights", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPMDDetails(@RequestParam(required = false) String airlineCode) {
        try {
            Map<String, Object> input = new HashMap<>();

            TestFlightInboundDTO inboundDTO = new TestFlightInboundDTO();
            inboundDTO.setAirlineCode(airlineCode);
            input.put(Utils.REQUEST.toString(), inboundDTO);

            TestFlightOutboundDTO outboundPayload = (TestFlightOutboundDTO) testFlightProvider.execute(input);

            return ResponseEntity.ok(outboundPayload);
        } catch (Exception e) {
            ErrorMessageDTO errorMessageDTO = ErrorMessageDTO.builder()
                    .code(ErrorCode.INTERNAL_SERVER_ERROR.getCode())
                    .message(e.getMessage())
                    .build();
            return ResponseEntity.internalServerError().body(errorMessageDTO);
        }
    }
}
