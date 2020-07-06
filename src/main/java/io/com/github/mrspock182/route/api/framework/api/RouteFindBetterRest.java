package io.com.github.mrspock182.route.api.framework.api;

import io.com.github.mrspock182.route.api.core.dto.RouteResponse;
import io.com.github.mrspock182.route.api.core.io.RouteFindBetterIO;
import io.com.github.mrspock182.route.api.core.service.RouteFindBetterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteFindBetterRest implements RouteFindBetterIO {

    private final RouteFindBetterService findBetterService;

    public RouteFindBetterRest(RouteFindBetterService findBetterService) {
        this.findBetterService = findBetterService;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/find-better/{from}/{to}")
    public RouteResponse findBetter(@PathVariable("from") String from, @PathVariable("to") String to) {
        return this.findBetterService.find(from, to);
    }
}
