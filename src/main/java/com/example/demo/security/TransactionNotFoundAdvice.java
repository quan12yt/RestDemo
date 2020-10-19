package com.example.demo.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.transaction.Transaction;

@RestControllerAdvice
public class TransactionNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TransactionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundHandle(TransactionNotFoundException transactionNotFoundException){
        return transactionNotFoundException.getMessage();
    }
}
