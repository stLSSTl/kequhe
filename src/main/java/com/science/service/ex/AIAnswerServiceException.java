package com.science.service.ex;

public class AIAnswerServiceException extends ServiceException{
    public AIAnswerServiceException() {
    }

    public AIAnswerServiceException(String message) {
        super(message);
    }

    public AIAnswerServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AIAnswerServiceException(Throwable cause) {
        super(cause);
    }

    public AIAnswerServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
