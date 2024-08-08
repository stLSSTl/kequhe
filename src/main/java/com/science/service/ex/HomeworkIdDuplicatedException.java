package com.science.service.ex;

public class HomeworkIdDuplicatedException extends ServiceException{
    public HomeworkIdDuplicatedException() {
    }

    public HomeworkIdDuplicatedException(String message) {
        super(message);
    }

    public HomeworkIdDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public HomeworkIdDuplicatedException(Throwable cause) {
        super(cause);
    }

    public HomeworkIdDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}