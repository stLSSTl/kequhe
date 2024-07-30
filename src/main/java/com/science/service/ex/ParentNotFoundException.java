package com.science.service.ex;

public class ParentNotFoundException extends ServiceException{
    public ParentNotFoundException() {
    }

    public ParentNotFoundException(String message) {
        super(message);
    }

    public ParentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParentNotFoundException(Throwable cause) {
        super(cause);
    }

    public ParentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
