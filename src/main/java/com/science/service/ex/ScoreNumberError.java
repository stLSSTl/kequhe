package com.science.service.ex;

/**
 * 成绩信息中分数范围出错，不在0-100之间
 */
public class ScoreNumberError  extends ServiceException{
    public ScoreNumberError() {
    }
    public ScoreNumberError(String message) {
        super(message);
    }
    public ScoreNumberError(String message, Throwable cause) {
        super(message, cause);
    }
    public ScoreNumberError(Throwable cause) {
        super(cause);
    }
    public ScoreNumberError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
