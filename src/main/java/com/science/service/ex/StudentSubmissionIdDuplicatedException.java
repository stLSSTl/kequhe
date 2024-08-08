package com.science.service.ex;

public class StudentSubmissionIdDuplicatedException extends ServiceException{
    public StudentSubmissionIdDuplicatedException() {
    }

    public StudentSubmissionIdDuplicatedException(String message) {
        super(message);
    }

    public StudentSubmissionIdDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentSubmissionIdDuplicatedException(Throwable cause) {
        super(cause);
    }

    public StudentSubmissionIdDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}