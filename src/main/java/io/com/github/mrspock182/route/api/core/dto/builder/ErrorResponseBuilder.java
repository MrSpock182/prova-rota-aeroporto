package io.com.github.mrspock182.route.api.core.dto.builder;

import io.com.github.mrspock182.route.api.core.dto.ErrorResponse;

import java.util.Date;

public final class ErrorResponseBuilder {
    private Date timestamp;
    private Integer status;
    private String error;
    private String message;

    private ErrorResponseBuilder() {
    }

    public static ErrorResponseBuilder builder() {
        return new ErrorResponseBuilder();
    }

    public ErrorResponseBuilder timestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public ErrorResponseBuilder status(Integer status) {
        this.status = status;
        return this;
    }

    public ErrorResponseBuilder error(String error) {
        this.error = error;
        return this;
    }

    public ErrorResponseBuilder message(String message) {
        this.message = message;
        return this;
    }

    public ErrorResponse build() {
        return new ErrorResponse(timestamp, status, error, message);
    }
}
