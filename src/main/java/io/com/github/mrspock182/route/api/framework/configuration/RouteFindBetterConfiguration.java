package io.com.github.mrspock182.route.api.framework.configuration;

import io.com.github.mrspock182.route.api.core.repository.AirportRepository;
import io.com.github.mrspock182.route.api.core.service.RouteFindBetterService;
import io.com.github.mrspock182.route.api.core.service.implementation.RouteFindBetterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteFindBetterConfiguration {

    @Bean
    public RouteFindBetterService routeFindBetterService(AirportRepository repository) {
        return new RouteFindBetterServiceImpl(repository);
    }

}
