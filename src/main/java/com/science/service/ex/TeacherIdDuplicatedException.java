package com.science.service.ex;

public class TeacherIdDuplicatedException extends ServiceException{
    public TeacherIdDuplicatedException() {
    }

    public TeacherIdDuplicatedException(String message) {
        super(message);
    }

    public TeacherIdDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeacherIdDuplicatedException(Throwable cause) {
        super(cause);
    }

    public TeacherIdDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
