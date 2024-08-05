package com.science.service.ex;

public class ScoreRecordNotFoundException extends ServiceException{
    public ScoreRecordNotFoundException() {
    }
    public ScoreRecordNotFoundException(String message) {
        super(message);
    }
    public ScoreRecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ScoreRecordNotFoundException(Throwable cause) {
        super(cause);
    }
    public ScoreRecordNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}