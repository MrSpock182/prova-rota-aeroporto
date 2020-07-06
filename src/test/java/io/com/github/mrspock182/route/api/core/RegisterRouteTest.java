package io.com.github.mrspock182.route.api.core;

import io.com.github.mrspock182.route.api.core.dto.Airport;
import io.com.github.mrspock182.route.api.core.dto.Destination;
import io.com.github.mrspock182.route.api.core.repository.AirportRepository;
import io.com.github.mrspock182.route.api.core.service.RouteRegisterService;
import io.com.github.mrspock182.route.api.core.service.implementation.RouteRegisterServiceImpl;
import io.com.github.mrspock182.route.api.framework.data.AirportRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class RegisterRouteTest {

    private final AirportRepository repository = new AirportRepositoryImpl();
    private final RouteRegisterService service = new RouteRegisterServiceImpl(repository);

    @Test
    void registerTest() {
        try {
            service.register("BAR,GRU,5");
            assertTrue(true);
        } catch (Exception ex) {
            fail(ex);
        }
    }
}
