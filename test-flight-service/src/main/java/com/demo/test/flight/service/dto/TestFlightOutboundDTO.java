package com.demo.test.flight.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestFlightOutboundDTO {

    @JsonProperty("flightDetails")
    private List<FlightDetailsDTO> flightDetails;

}
