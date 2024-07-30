package com.science.service.ex;

public class StudentIdDuplicatedException extends ServiceException{
    public StudentIdDuplicatedException() {
    }

    public StudentIdDuplicatedException(String message) {
        super(message);
    }

    public StudentIdDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentIdDuplicatedException(Throwable cause) {
        super(cause);
    }

    public StudentIdDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
