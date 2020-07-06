package io.com.github.mrspock182.route.api.core.service;

import io.com.github.mrspock182.route.api.core.dto.RouteResponse;

public interface RouteFindBetterService {
    RouteResponse find(String from, String to);
}
