package com.demo.test.flight.service.samples;

import com.demo.test.flight.service.dto.FlightDetailsDTO;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SampleFlightsList {

    private static final String utcFormat = "UTC ISO8601 format ";
    private static final ZonedDateTime sampleZDt = ZonedDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public static List<FlightDetailsDTO> buildFlightDetailsList() {
        List<FlightDetailsDTO> flights = new ArrayList<>();
        flights.add(flightOne());
        flights.add(flightTwo());
        flights.add(flightThree());
        flights.add(flightFour());
        flights.add(flightFive());
        return flights;
    }

    private static FlightDetailsDTO flightOne() {
        return FlightDetailsDTO.builder()
                .flightNumber("QF001")
                .departurePort("SYD")
                .arrivalPort("BNE")
                .departureTime(utcFormat + sampleZDt.format(formatter))
                .arrivalTime(utcFormat + sampleZDt.plusMinutes(30L).format(formatter))
                .build();
    }

    private static FlightDetailsDTO flightTwo() {
        return FlightDetailsDTO.builder()
                .flightNumber("QF002")
                    .departurePort("SYD")
                .arrivalPort("MEL")
                .departureTime(utcFormat + sampleZDt.format(formatter))
                .arrivalTime(utcFormat + sampleZDt.plusHours(1L).plusMinutes(30L).format(formatter))
                .build();
    }

    private static FlightDetailsDTO flightThree() {
        return FlightDetailsDTO.builder()
                .flightNumber("QF003")
                .departurePort("SYD")
                .arrivalPort("TMW")
                .departureTime(utcFormat + sampleZDt.format(formatter))
                .arrivalTime(utcFormat + sampleZDt.plusHours(1L).format(formatter))
                .build();
    }

    private static FlightDetailsDTO flightFour() {
        return FlightDetailsDTO.builder()
                .flightNumber("QF004")
                .departurePort("SYD")
                .arrivalPort("ADL")
                .departureTime(utcFormat + sampleZDt.format(formatter))
                .arrivalTime(utcFormat + sampleZDt.plusHours(2L).format(formatter))
                .build();
    }

    private static FlightDetailsDTO flightFive() {
        return FlightDetailsDTO.builder()
                .flightNumber("QF005")
                .departurePort("SYD")
                .arrivalPort("MKY")
                .departureTime(utcFormat + sampleZDt.format(formatter))
                .arrivalTime(utcFormat + sampleZDt.plusHours(5L).format(formatter))
                .build();
    }
}
