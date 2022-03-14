package com.demo.test.flight.domain.service;

import com.demo.test.flight.domain.entity.SampleFlights;

import java.util.List;

public interface SampleFlightsService {

    SampleFlights save(SampleFlights sampleFlights);

    List<SampleFlights> findTodayFlights();

    List<SampleFlights> findTodayFlights(String airlineCd);
}
