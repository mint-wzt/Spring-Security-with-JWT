package com.wzt.restfulapi.system.exception;

public class UserNameAlreadyExistException  extends RuntimeException{
    public UserNameAlreadyExistException(){}

    public UserNameAlreadyExistException(String message){
        super(message);
    }
}
