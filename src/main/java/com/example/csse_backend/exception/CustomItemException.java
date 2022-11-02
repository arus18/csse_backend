package com.example.csse_backend.exception;

public class CustomItemException extends RuntimeException{

    public String ERROR;

    public CustomItemException(String error){
        this.ERROR = error;
    }
}
