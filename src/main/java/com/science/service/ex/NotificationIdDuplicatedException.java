package com.science.service.ex;

public class NotificationIdDuplicatedException extends ServiceException{
    public NotificationIdDuplicatedException() {
    }

    public NotificationIdDuplicatedException(String message) {
        super(message);
    }

    public NotificationIdDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotificationIdDuplicatedException(Throwable cause) {
        super(cause);
    }

    public NotificationIdDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
