package io.com.github.mrspock182.route.api.core.dto;

import java.util.List;

public class RouteResponse {
    private final List<String> route;
    private final Integer price;

    public RouteResponse(List<String> route, Integer price) {
        this.route = route;
        this.price = price;
    }

    public List<String> getRoute() {
        return route;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "RouteResponse{" +
                "route=" + route +
                ", price=" + price +
                '}';
    }
}
