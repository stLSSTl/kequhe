package com.science.service.ex;

public class InteractionIdDuplicatedException extends ServiceException{
    public InteractionIdDuplicatedException() {
    }

    public InteractionIdDuplicatedException(String message) {
        super(message);
    }

    public InteractionIdDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public InteractionIdDuplicatedException(Throwable cause) {
        super(cause);
    }

    public InteractionIdDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
