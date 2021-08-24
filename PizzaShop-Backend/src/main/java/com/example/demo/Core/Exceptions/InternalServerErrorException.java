package com.example.demo.Core.Exceptions;

public class InternalServerErrorException extends RuntimeException{
    private final InternalServerErrorEnum internalServerErrorEnum;

    public InternalServerErrorException(InternalServerErrorEnum internalServerErrorEnum){
        super("Internal Server Error");
        this.internalServerErrorEnum = internalServerErrorEnum;
    }

    public final InternalServerErrorEnum getInternalServerErrorEnum(){
        return this.internalServerErrorEnum;
    }
}
