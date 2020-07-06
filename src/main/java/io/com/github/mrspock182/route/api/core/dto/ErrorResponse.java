package io.com.github.mrspock182.route.api.core.dto;

import java.util.Date;

public class ErrorResponse {
    private final Date timestamp;
    private final Integer status;
    private final String error;
    private final String message;

    public ErrorResponse(Date timestamp, Integer status, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
