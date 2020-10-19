package com.example.demo.security;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(int id){
        super("Could not find User :"+id);
    }
}
