package com.example.demo.exception;

public class TransactionNotFoundException extends RuntimeException{
    public TransactionNotFoundException(Long id){
        super("Could not find User :"+id);
    }
}
