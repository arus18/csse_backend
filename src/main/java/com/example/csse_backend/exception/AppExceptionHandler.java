package com.example.csse_backend.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CustomPurchaseOrderException.class})
    public ResponseEntity handleOrderNotFoundException(CustomPurchaseOrderException ex, WebRequest webRequest){
        return new ResponseEntity<>(ex.ERROR, HttpStatus.OK);
    }

    @ExceptionHandler(value = {CustomItemException.class})
    public ResponseEntity handleItemNotFoundException(CustomItemException ex, WebRequest webRequest){
        return new ResponseEntity<>(ex.ERROR, HttpStatus.OK);
    }

}
