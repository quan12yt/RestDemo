package com.example.demo.security;

import com.example.demo.model.Transactions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class TransactionNotFoundException extends RuntimeException{
    public TransactionNotFoundException(int id){
        super("Could not find User :"+id);
    }
}
