package com.science.controller.ex;

public class AIPainterException extends RuntimeException{
    public AIPainterException() {
    }

    public AIPainterException(String message) {
        super(message);
    }

    public AIPainterException(String message, Throwable cause) {
        super(message, cause);
    }

    public AIPainterException(Throwable cause) {
        super(cause);
    }

    public AIPainterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
