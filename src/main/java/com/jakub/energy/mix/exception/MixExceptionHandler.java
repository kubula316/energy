package com.jakub.energy.mix.exception;

import com.jakub.energy.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class MixExceptionHandler {

    @ExceptionHandler(ExternalDataFetchException.class)
    public ProblemDetail handleExternalDataFetchException(ExternalDataFetchException e) {
        log.error("Failed to fetch external data in Mix module: {}", e.getMessage(), e);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_GATEWAY, e.getMessage());
        problemDetail.setTitle("External Data Error");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(OptimalChargingWindowNotFoundException.class)
    public ProblemDetail handleOptimalChargingWindowNotFoundException(OptimalChargingWindowNotFoundException e) {
        log.warn("Optimization failed: {}", e.getMessage());
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Optimization Failed");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(BusinessException.class)
    public ProblemDetail handleBusinessException(BusinessException e) {
        log.warn("Business logic error in Mix module: {}", e.getMessage());
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setTitle("Business Error");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
