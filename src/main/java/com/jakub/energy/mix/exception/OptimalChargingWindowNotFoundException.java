package com.jakub.energy.mix.exception;

import com.jakub.energy.exception.BusinessException;

public class OptimalChargingWindowNotFoundException extends BusinessException {
    public OptimalChargingWindowNotFoundException(String message) {
        super(message);
    }
}
