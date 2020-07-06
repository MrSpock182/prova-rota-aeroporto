package io.com.github.mrspock182.route.api.core.dto;

import java.util.List;

public class Airport {
    private final String name;
    private final List<Destination> destinations;

    public Airport(String name, List<Destination> destinations) {
        this.name = name;
        this.destinations = destinations;
    }

    public String getName() {
        return name;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }
}
