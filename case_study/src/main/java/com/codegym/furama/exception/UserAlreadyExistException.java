package com.codegym.furama.exception;

public class UserAlreadyExistException extends Exception{

    private String message;
    public UserAlreadyExistException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
