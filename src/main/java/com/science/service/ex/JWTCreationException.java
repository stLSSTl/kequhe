package com.science.service.ex;

public class JWTCreationException extends ServiceException{
    public JWTCreationException() {
    }

    public JWTCreationException(String message) {
        super(message);
    }

    public JWTCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public JWTCreationException(Throwable cause) {
        super(cause);
    }

    public JWTCreationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
