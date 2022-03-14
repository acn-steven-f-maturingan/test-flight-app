package com.demo.test.flight.domain.provider;

import com.demo.test.flight.domain.entity.SampleFlights;
import com.demo.test.flight.domain.repository.SampleFlightsRepository;
import com.demo.test.flight.domain.service.SampleFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleFlightsProvider implements SampleFlightsService {

    @Autowired
    private SampleFlightsRepository sampleFlightsRepository;

    @Override
    public SampleFlights save(SampleFlights sampleFlights) {
        return sampleFlightsRepository.save(sampleFlights);
    }

    @Override
    public List<SampleFlights> findTodayFlights() {
        return sampleFlightsRepository.findTodayFlights();
    }

    @Override
    public List<SampleFlights> findTodayFlights(String airlineCd) {
        return sampleFlightsRepository.findTodayFlights(airlineCd);
    }

}
