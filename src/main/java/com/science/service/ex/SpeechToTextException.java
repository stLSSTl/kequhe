package com.science.service.ex;

public class SpeechToTextException extends ServiceException{
    public SpeechToTextException() {
    }

    public SpeechToTextException(String message) {
        super(message);
    }

    public SpeechToTextException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpeechToTextException(Throwable cause) {
        super(cause);
    }

    public SpeechToTextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
