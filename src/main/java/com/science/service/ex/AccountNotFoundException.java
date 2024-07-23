package com.science.service.ex;

/**
 * 账号不存在异常
 */
public class AccountNotFoundException extends ServiceException{
    public AccountNotFoundException() {}
    public AccountNotFoundException(String message) {
        super(message);
    }
    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public AccountNotFoundException(Throwable cause) {
        super(cause);
    }
    public AccountNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
