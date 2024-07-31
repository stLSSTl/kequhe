package com.science.service.ex;

public class ParentIdDuplicatedException extends ServiceException{
    public ParentIdDuplicatedException() {
    }

    public ParentIdDuplicatedException(String message) {
        super(message);
    }

    public ParentIdDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParentIdDuplicatedException(Throwable cause) {
        super(cause);
    }

    public ParentIdDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
