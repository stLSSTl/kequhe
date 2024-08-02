package com.science.service.ex;

public class StudentDuplicatedException extends ServiceException{
    public StudentDuplicatedException() {
    }

    public StudentDuplicatedException(String message) {
        super(message);
    }

    public StudentDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentDuplicatedException(Throwable cause) {
        super(cause);
    }

    public StudentDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
