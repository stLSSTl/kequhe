package com.science.service.ex;

public class TeacherDuplicatedException extends ServiceException{
    public TeacherDuplicatedException() {
    }

    public TeacherDuplicatedException(String message) {
        super(message);
    }

    public TeacherDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeacherDuplicatedException(Throwable cause) {
        super(cause);
    }

    public TeacherDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
