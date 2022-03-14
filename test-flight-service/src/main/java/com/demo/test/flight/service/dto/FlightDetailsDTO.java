package com.demo.test.flight.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDetailsDTO {
    @JsonProperty("flightNumber")
    private String flightNumber;
    @JsonProperty("departurePort")
    private String departurePort;
    @JsonProperty("arrivalPort")
    private String arrivalPort;
    @JsonProperty("departureTime")
    private String departureTime;
    @JsonProperty("arrivalTime")
    private String arrivalTime;
}
