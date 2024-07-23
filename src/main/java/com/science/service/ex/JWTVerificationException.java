package com.science.service.ex;

public class JWTVerificationException extends ServiceException{
    public JWTVerificationException() {
    }

    public JWTVerificationException(String message) {
        super(message);
    }

    public JWTVerificationException(String message, Throwable cause) {
        super(message, cause);
    }

    public JWTVerificationException(Throwable cause) {
        super(cause);
    }

    public JWTVerificationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
