package io.com.github.mrspock182.route.api.core.service.implementation;

import io.com.github.mrspock182.route.api.core.repository.AirportRepository;
import io.com.github.mrspock182.route.api.core.service.RouteRegisterService;

public class RouteRegisterServiceImpl implements RouteRegisterService {

    private final AirportRepository repository;

    public RouteRegisterServiceImpl(AirportRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(String value) {
        repository.save(value);
    }
}
