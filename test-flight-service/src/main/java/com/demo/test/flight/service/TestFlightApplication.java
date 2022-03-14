package com.demo.test.flight.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.demo.test.flight.service"
		, "com.demo.test.flight.domain.entity"
		, "com.demo.test.flight.domain.repository"
		, "com.demo.test.flight.domain.provider"})
@EntityScan("com.demo.test.flight.domain.entity")
@EnableJpaRepositories(basePackages = {"com.demo.test.flight.service", "com.demo.test.flight.domain.repository"})
public class TestFlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestFlightApplication.class, args);
	}

}
