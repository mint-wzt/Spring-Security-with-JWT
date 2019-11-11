package com.wzt.restfulapi.exception;

public class NotFoundException extends GlobalException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, int code) {
        super(message, code);
    }
}
