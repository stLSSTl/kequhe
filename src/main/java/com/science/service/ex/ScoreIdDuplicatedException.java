package com.science.service.ex;

/**
 * 成绩记录的编号重复
 */
public class ScoreIdDuplicatedException extends ServiceException{
    public ScoreIdDuplicatedException() {
    }
    public ScoreIdDuplicatedException(String message) {
        super(message);
    }
    public ScoreIdDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }
    public ScoreIdDuplicatedException(Throwable cause) {
        super(cause);
    }
    public ScoreIdDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}