package com.example.csse_backend.exception;

public class CustomPurchaseOrderException extends RuntimeException{

    public String ERROR;

    public CustomPurchaseOrderException(String error){
        this.ERROR = error;
    }
}
