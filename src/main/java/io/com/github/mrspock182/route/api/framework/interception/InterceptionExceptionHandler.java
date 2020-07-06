package io.com.github.mrspock182.route.api.framework.interception;

import io.com.github.mrspock182.route.api.core.dto.ErrorResponse;
import io.com.github.mrspock182.route.api.core.dto.builder.ErrorResponseBuilder;
import io.com.github.mrspock182.route.api.exception.BadRequest;
import io.com.github.mrspock182.route.api.exception.InternalServerError;
import io.com.github.mrspock182.route.api.exception.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class InterceptionExceptionHandler {

    @ExceptionHandler(BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(BadRequest badRequest) {
        return ErrorResponseBuilder.builder()
                .timestamp(new Date())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("BAD REQUEST")
                .message(badRequest.getMessage())
                .build();
    }

    @ExceptionHandler(InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleInternalServerError(InternalServerError internalServerError) {
        return ErrorResponseBuilder.builder()
                .timestamp(new Date())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("INTERNAL SERVER ERROR")
                .message(internalServerError.getMessage())
                .build();
    }

    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(NotFound notFoundException) {
        return ErrorResponseBuilder.builder()
                .timestamp(new Date())
                .status(HttpStatus.NOT_FOUND.value())
                .error("NOT FOUND")
                .message(notFoundException.getMessage())
                .build();
    }

}
