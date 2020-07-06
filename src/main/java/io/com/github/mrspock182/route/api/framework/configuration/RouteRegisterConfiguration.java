package io.com.github.mrspock182.route.api.framework.configuration;

import io.com.github.mrspock182.route.api.core.repository.AirportRepository;
import io.com.github.mrspock182.route.api.core.service.RouteRegisterService;
import io.com.github.mrspock182.route.api.core.service.implementation.RouteRegisterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteRegisterConfiguration {

    @Bean
    public RouteRegisterService routeRegisterService(AirportRepository repository) {
        return new RouteRegisterServiceImpl(repository);
    }

}
