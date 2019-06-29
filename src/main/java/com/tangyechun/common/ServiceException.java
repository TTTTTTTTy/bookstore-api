package com.tangyechun.common;

/**
 * @author Administrator
 * @since 2019/6/21 23:56
 */
public class ServiceException extends RuntimeException {

    private int errorCode;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;

    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getErrorCode() {
        return errorCode;
    }

}
