package io.com.github.mrspock182.route.api.core.io;

import io.com.github.mrspock182.route.api.core.dto.RouteResponse;

public interface RouteFindBetterIO {
    RouteResponse findBetter(String from, String to);
}
