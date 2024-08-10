package com.science.controller.ex;

public class GetRandomStudentException extends RuntimeException{
    public GetRandomStudentException() {
    }

    public GetRandomStudentException(String message) {
        super(message);
    }

    public GetRandomStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public GetRandomStudentException(Throwable cause) {
        super(cause);
    }

    public GetRandomStudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
