package io.com.github.mrspock182.route.api.core.dto;

public class Destination {
    private final Integer weight;
    private final Airport airport;

    public Destination(Integer weight, Airport airport) {
        this.weight = weight;
        this.airport = airport;
    }

    public Integer getWeight() {
        return weight;
    }

    public Airport getAirport() {
        return airport;
    }
}
