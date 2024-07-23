package com.science.service.ex;

/**
 * 账号不存在异常
 */
public class AccountNotFoundException extends ServiceException{
    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
