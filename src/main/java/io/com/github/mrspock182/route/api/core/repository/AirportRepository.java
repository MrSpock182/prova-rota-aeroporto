package io.com.github.mrspock182.route.api.core.repository;

import io.com.github.mrspock182.route.api.core.dto.Airport;

import java.util.Map;

public interface AirportRepository {
    void save(String airport);

    Map<String, Airport> findAll();
}
