package com.example.CRUD.exception;

public class CountryNotFoundException extends  RuntimeException{
    public CountryNotFoundException(String exception){
        super(exception);
    }
}
