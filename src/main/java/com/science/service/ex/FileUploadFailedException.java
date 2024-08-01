package com.science.service.ex;

public class FileUploadFailedException extends ServiceException{
    public FileUploadFailedException() {
    }

    public FileUploadFailedException(String message) {
        super(message);
    }

    public FileUploadFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadFailedException(Throwable cause) {
        super(cause);
    }

    public FileUploadFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
