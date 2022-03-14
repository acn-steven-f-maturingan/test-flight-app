package com.demo.test.flight.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TestFlightInboundDTO {

    @JsonProperty("airlineCode")
    private String airlineCode;

}
