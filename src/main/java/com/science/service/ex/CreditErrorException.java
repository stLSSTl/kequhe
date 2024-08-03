package com.science.service.ex;

public class CreditErrorException extends ServiceException{
    public CreditErrorException() {
    }
    public CreditErrorException(String message) {
        super(message);
    }
    public CreditErrorException(String message, Throwable cause) {
        super(message, cause);
    }
    public CreditErrorException(Throwable cause) {
        super(cause);
    }
    public CreditErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
