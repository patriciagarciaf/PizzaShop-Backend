package com.example.demo.Core.Exceptions;

import java.util.HashMap;
import java.util.Map;

//TODO: RESOLVER EL PROBLEMA DE LO QUE ESTÁ COMENTADO

public class BadRequestException extends RuntimeException {
    private final Map<String, String> map = new HashMap<String, String>();
   // private final String _message = "Bad Request";

    public BadRequestException(){
        //String _message = this._message;
        this("Bad Request");
    }

    public BadRequestException(String message){
        super(message);
    }

    public Map<String,String> getExceptions(){
        return this.map;
    }

    public void addException(String key, String message){
        this.map.put(key, message);
    }
}
