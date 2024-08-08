package com.science.service.ex;

public class StudentSubmissionNotFoundException extends ServiceException{
    public StudentSubmissionNotFoundException() {
    }

    public StudentSubmissionNotFoundException(String message) {
        super(message);
    }

    public StudentSubmissionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentSubmissionNotFoundException(Throwable cause) {
        super(cause);
    }

    public StudentSubmissionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}