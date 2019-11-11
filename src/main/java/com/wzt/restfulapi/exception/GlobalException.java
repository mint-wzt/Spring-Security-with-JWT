package com.wzt.restfulapi.exception;

import lombok.Data;

@Data
public class GlobalException extends Exception {
    private int code;

    public GlobalException(String message){
        super(message);
    }

    public GlobalException(String message,int code){
        super(message);
        this.code = code;
    }
}
