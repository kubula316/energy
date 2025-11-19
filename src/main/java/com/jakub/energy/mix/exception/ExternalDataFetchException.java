package com.jakub.energy.mix.exception;

import com.jakub.energy.exception.BusinessException;

public class ExternalDataFetchException extends BusinessException {
    public ExternalDataFetchException(String message, Throwable cause) {
        super(message, cause);
    }
}
