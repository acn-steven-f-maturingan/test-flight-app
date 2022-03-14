package com.demo.test.flight.service.helper;

import com.demo.test.flight.domain.entity.SampleFlights;
import com.demo.test.flight.service.dto.FlightDetailsDTO;
import com.demo.test.flight.service.dto.TestFlightOutboundDTO;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TestClassHelper {

    private static final String UTC_FORMAT = "UTC ISO8601 format ";
    private static final ZonedDateTime SAMPLE_ZDT = ZonedDateTime.now();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static final String DEFAULT_STRING_TEST = "TEST";
    private static final LocalDateTime SAMPLE_LDT = LocalDateTime.now();

    public static TestFlightOutboundDTO buildTestFlightOutboundDTO() {
        TestFlightOutboundDTO outboundDTO = new TestFlightOutboundDTO();
        outboundDTO.setFlightDetails(buildFlightDetailsList());
        return outboundDTO;
    }

    public static List<SampleFlights> buildFlightsList() {
        List<SampleFlights> flightsList = new ArrayList<>();
        flightsList.add(buildSampleFlights("QF"));
        flightsList.add(buildSampleFlights("EK"));
        flightsList.add(buildSampleFlights("CX"));
        return flightsList;
    }

    private static SampleFlights buildSampleFlights(String airlineCode) {
        SampleFlights sampleFlights = new SampleFlights();
        sampleFlights.setFlightNumber(DEFAULT_STRING_TEST);
        sampleFlights.setAirlineCd(airlineCode);
        sampleFlights.setDeparturePort(DEFAULT_STRING_TEST);
        sampleFlights.setArrivalPort(DEFAULT_STRING_TEST);
        sampleFlights.setDepartureTime(SAMPLE_LDT);
        sampleFlights.setArrivalTime(SAMPLE_LDT);
        return sampleFlights;
    }

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
                .departureTime(UTC_FORMAT + SAMPLE_ZDT.format(FORMATTER))
                .arrivalTime(UTC_FORMAT + SAMPLE_ZDT.plusMinutes(30L).format(FORMATTER))
                .build();
    }

    private static FlightDetailsDTO flightTwo() {
        return FlightDetailsDTO.builder()
                .flightNumber("QF002")
                .departurePort("SYD")
                .arrivalPort("MEL")
                .departureTime(UTC_FORMAT + SAMPLE_ZDT.format(FORMATTER))
                .arrivalTime(UTC_FORMAT + SAMPLE_ZDT.plusHours(1L).plusMinutes(30L).format(FORMATTER))
                .build();
    }

    private static FlightDetailsDTO flightThree() {
        return FlightDetailsDTO.builder()
                .flightNumber("QF003")
                .departurePort("SYD")
                .arrivalPort("TMW")
                .departureTime(UTC_FORMAT + SAMPLE_ZDT.format(FORMATTER))
                .arrivalTime(UTC_FORMAT + SAMPLE_ZDT.plusHours(1L).format(FORMATTER))
                .build();
    }

    private static FlightDetailsDTO flightFour() {
        return FlightDetailsDTO.builder()
                .flightNumber("QF004")
                .departurePort("SYD")
                .arrivalPort("ADL")
                .departureTime(UTC_FORMAT + SAMPLE_ZDT.format(FORMATTER))
                .arrivalTime(UTC_FORMAT + SAMPLE_ZDT.plusHours(2L).format(FORMATTER))
                .build();
    }

    private static FlightDetailsDTO flightFive() {
        return FlightDetailsDTO.builder()
                .flightNumber("QF005")
                .departurePort("SYD")
                .arrivalPort("MKY")
                .departureTime(UTC_FORMAT + SAMPLE_ZDT.format(FORMATTER))
                .arrivalTime(UTC_FORMAT + SAMPLE_ZDT.plusHours(5L).format(FORMATTER))
                .build();
    }
}
