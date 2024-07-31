package com.science.service.ex;

public class VideoIdDuplicatedException extends ServiceException{
    public VideoIdDuplicatedException() {
    }

    public VideoIdDuplicatedException(String message) {
        super(message);
    }

    public VideoIdDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public VideoIdDuplicatedException(Throwable cause) {
        super(cause);
    }

    public VideoIdDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
