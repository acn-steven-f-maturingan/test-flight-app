package com.demo.test.flight.service.task;

import com.demo.test.flight.domain.entity.SampleFlights;
import com.demo.test.flight.domain.service.SampleFlightsService;
import com.demo.test.flight.service.dto.FlightDetailsDTO;
import com.demo.test.flight.service.dto.TestFlightInboundDTO;
import com.demo.test.flight.service.dto.TestFlightOutboundDTO;
import com.demo.test.flight.service.enums.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;

@Service("GetFlightTask")
public class GetFlightTask {

    @Autowired
    private SampleFlightsService sampleFlightsService;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static final String utcFormat = "UTC ISO8601 format ";

    public Map<String, Object> process(Map<String, Object> input) {

        TestFlightInboundDTO inboundDTO = (TestFlightInboundDTO) input.get(Utils.REQUEST.toString());
        Map<String, Object> output = new HashMap<>();

        List<FlightDetailsDTO> flights = new ArrayList<>();

        TestFlightOutboundDTO testFlightOutboundDTO = new TestFlightOutboundDTO();

        List<SampleFlights> flightsList = new ArrayList<>();

        if (Objects.isNull(inboundDTO.getAirlineCode())) {
            flightsList = sampleFlightsService.findTodayFlights();
        } else {
            flightsList = sampleFlightsService.findTodayFlights(inboundDTO.getAirlineCode());
        }

        flightsList.forEach(flight -> {
                    FlightDetailsDTO flightDetails = new FlightDetailsDTO();
                    flightDetails.setFlightNumber(flight.getFlightNumber());
                    flightDetails.setDeparturePort(flight.getDeparturePort());
                    flightDetails.setArrivalPort(flight.getArrivalPort());
                    flightDetails.setDepartureTime(utcFormat + formatter.format(flight.getDepartureTime()));
                    flightDetails.setArrivalTime(utcFormat + formatter.format(flight.getArrivalTime()));
                    flights.add(flightDetails);
                }
        );
        testFlightOutboundDTO.setFlightDetails(flights);


        output.put(Utils.RESPONSE.toString(), testFlightOutboundDTO);

        return output;
    }
}
