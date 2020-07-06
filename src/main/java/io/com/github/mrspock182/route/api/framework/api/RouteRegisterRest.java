package io.com.github.mrspock182.route.api.framework.api;

import io.com.github.mrspock182.route.api.core.io.RouteRegisterIO;
import io.com.github.mrspock182.route.api.core.service.RouteRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteRegisterRest implements RouteRegisterIO {

    private final RouteRegisterService service;

    public RouteRegisterRest(RouteRegisterService service) {
        this.service = service;
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/register/{from}/{to}/{price}")
    public void register(@PathVariable("from") String from,
                         @PathVariable("to") String to,
                         @PathVariable("price") String price) {
        service.register(from + "," + to + "," + price);
    }
}
