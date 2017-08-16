package com.globant.finalproject.controllers;


public class MyException extends RuntimeException {

    private String message;

    public MyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
