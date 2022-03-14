package com.demo.test.flight.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SAMPLE_FLIGHTS")
public class SampleFlights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "FLIGHT_NUMBER")
    private String flightNumber;
    @Column(name = "AIRLINE_CD")
    private String airlineCd;
    @Column(name = "DEPARTURE_PORT")
    private String departurePort;
    @Column(name = "ARRIVAL_PORT")
    private String arrivalPort;
    @Column(name = "DEPARTURE_TIME")
    private LocalDateTime departureTime;
    @Column(name = "ARRIVAL_TIME")
    private LocalDateTime arrivalTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirlineCd() {
        return airlineCd;
    }

    public void setAirlineCd(String airlineCd) {
        this.airlineCd = airlineCd;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(String departurePort) {
        this.departurePort = departurePort;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    public void setArrivalPort(String arrivalPort) {
        this.arrivalPort = arrivalPort;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
