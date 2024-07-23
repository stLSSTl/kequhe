package com.science.service.ex;

/**
 * 密码错误异常
 */
public class PasswordErrorException extends ServiceException{
    public PasswordErrorException() {
    }

    public PasswordErrorException(String msg) {
        super(msg);
    }
}
