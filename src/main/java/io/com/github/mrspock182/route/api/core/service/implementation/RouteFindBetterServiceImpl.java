package io.com.github.mrspock182.route.api.core.service.implementation;

import io.com.github.mrspock182.route.api.core.dto.Airport;
import io.com.github.mrspock182.route.api.core.dto.Destination;
import io.com.github.mrspock182.route.api.core.dto.RouteResponse;
import io.com.github.mrspock182.route.api.core.repository.AirportRepository;
import io.com.github.mrspock182.route.api.core.service.RouteFindBetterService;
import io.com.github.mrspock182.route.api.exception.BadRequest;
import io.com.github.mrspock182.route.api.exception.NotFound;

import java.util.*;

public class RouteFindBetterServiceImpl implements RouteFindBetterService {
    private final Map<String, Airport> graph;
    private final Set<String> settledAirports = new HashSet<>();
    private final Set<String> unsettledAirports = new HashSet<>();
    private final Map<String, Integer> cheapestPriceFromSource = new HashMap<>();
    private final Map<String, String> predecessors = new HashMap<>();

    public RouteFindBetterServiceImpl(AirportRepository repository) {
        this.graph = repository.findAll();
    }

    @Override
    public RouteResponse find(String from, String to) {
        Airport sourceAirport = graph.get(from);

        if(sourceAirport == null) {
            throw new BadRequest("Airplane don't exists");
        }

        cheapestPriceFromSource.put(sourceAirport.getName(), 0);
        unsettledAirports.add(sourceAirport.getName());
        setCheapestPriceFromSource(unsettledAirports);

        if(!routeValidation(sourceAirport, to)) {
            throw new NotFound("Route don't exists");
        }

        return new RouteResponse(getRouteAirports(to), this.cheapestPriceFromSource.get(to));
    }

    private boolean routeValidation(Airport sourceAirport, String to) {
        for (Destination destination : sourceAirport.getDestinations()) {
            if(destination.getAirport().getName().equalsIgnoreCase(to)) {
                return true;
            }
        }
        return false;
    }

    private void setCheapestPriceFromSource(Set<String> unsettledAirports) {
        while(!unsettledAirports.isEmpty()) {
            Airport currentSource = getCheaper(unsettledAirports);
            String currentSourceAirportName = currentSource.getName();
            settledAirports.add(currentSourceAirportName);
            unsettledAirports.remove(currentSourceAirportName);

            for (Destination destination : currentSource.getDestinations()) {
                if (!settledAirports.contains(destination.getAirport().getName())) {
                    String currentDestinationName = destination.getAirport().getName();
                    int priceFromCurrentSource = this.cheapestPriceFromSource.get(currentSourceAirportName) + destination.getWeight();
                    if (cheapestPriceFromSource(currentDestinationName) > priceFromCurrentSource) {
                        this.cheapestPriceFromSource.put(currentDestinationName, priceFromCurrentSource);
                        predecessors.put(currentDestinationName, currentSourceAirportName);
                        unsettledAirports.add(currentDestinationName);
                    }
                }
            }
        }
    }

    private List<String> getRouteAirports(String destination) {
        List<String> route = new ArrayList<>();

        String nextPredecessor = destination;
        while (nextPredecessor != null) {
            route.add(nextPredecessor);
            nextPredecessor = this.predecessors.get(nextPredecessor);
        }

        Collections.reverse(route);
        return route;
    }

    private int cheapestPriceFromSource(String airport) {
        return this.cheapestPriceFromSource.computeIfAbsent(airport, k -> Integer.MAX_VALUE);
    }

    private Airport getCheaper(Collection<String> destinations) {
        Integer minDistance = Integer.MAX_VALUE;
        Airport minDestination = null;
        for (String destination : destinations) {
            Integer distance = this.cheapestPriceFromSource.get(destination);
            if (distance < minDistance) {
                minDistance = distance;
                minDestination = this.graph.get(destination);
            }
        }
        return minDestination;
    }

}
