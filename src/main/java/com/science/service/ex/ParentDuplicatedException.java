package com.science.service.ex;

public class ParentDuplicatedException extends ServiceException{
    public ParentDuplicatedException() {
    }

    public ParentDuplicatedException(String message) {
        super(message);
    }

    public ParentDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParentDuplicatedException(Throwable cause) {
        super(cause);
    }

    public ParentDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
