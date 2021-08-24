package com.example.demo.Core.Exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        this("Not found exception");
    }
    public NotFoundException(String message){
        super(message);
    }
    
}
