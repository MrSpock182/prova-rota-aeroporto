package io.com.github.mrspock182.route.api.core;

import io.com.github.mrspock182.route.api.core.dto.Airport;
import io.com.github.mrspock182.route.api.core.dto.Destination;
import io.com.github.mrspock182.route.api.core.dto.RouteResponse;
import io.com.github.mrspock182.route.api.core.repository.AirportRepository;
import io.com.github.mrspock182.route.api.core.service.RouteFindBetterService;
import io.com.github.mrspock182.route.api.core.service.implementation.RouteFindBetterServiceImpl;
import io.com.github.mrspock182.route.api.exception.NotFound;
import io.com.github.mrspock182.route.api.framework.data.AirportRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FindBetterRouteTest {

    private final AirportRepository repository = new AirportRepositoryImpl();
    private final RouteFindBetterService service = new RouteFindBetterServiceImpl(repository);

    @Test
    void findTestGruCdg() {
        List<String> list = Arrays.asList("GRU", "BRC", "SCL", "ORL", "CDG");
        RouteResponse response = service.find("GRU", "CDG");
        assertEquals(40, response.getPrice());
        assertEquals(list, response.getRoute());
    }

    @Test
    void findTestGruOrl() {
        List<String> list = Arrays.asList("GRU", "BRC", "SCL", "ORL");
        RouteResponse response = service.find("GRU", "ORL");
        assertEquals(35, response.getPrice());
        assertEquals(list, response.getRoute());
    }

    @Test
    void findTestOrlGru() {
        try {
            service.find("ORL", "GRU");
        } catch (NotFound ex) {
            assertEquals("Route don't exists", ex.getMessage());
        }
    }
}
