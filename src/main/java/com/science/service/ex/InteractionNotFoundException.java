package com.science.service.ex;

public class InteractionNotFoundException extends ServiceException{
    public InteractionNotFoundException() {
    }

    public InteractionNotFoundException(String message) {
        super(message);
    }

    public InteractionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InteractionNotFoundException(Throwable cause) {
        super(cause);
    }

    public InteractionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
