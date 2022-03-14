package com.demo.test.flight.domain.repository;

import com.demo.test.flight.domain.entity.SampleFlights;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleFlightsRepository extends CrudRepository<SampleFlights, Long> {

    @Query("SELECT sf from SampleFlights sf where DATE(sf.arrivalTime) = CURDATE()")
    List<SampleFlights> findTodayFlights();

    @Query("SELECT sf from SampleFlights sf where DATE(sf.arrivalTime) = CURDATE() and sf.airlineCd = ?1")
    List<SampleFlights> findTodayFlights(String airlineCd);
}