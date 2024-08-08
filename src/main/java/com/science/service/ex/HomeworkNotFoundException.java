package com.science.service.ex;

public class HomeworkNotFoundException extends ServiceException{
    public HomeworkNotFoundException() {
    }

    public HomeworkNotFoundException(String message) {
        super(message);
    }

    public HomeworkNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HomeworkNotFoundException(Throwable cause) {
        super(cause);
    }

    public HomeworkNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}