package com.nurseService.exceptions;

public class ResouseNotFoundException extends RuntimeException {
    public ResouseNotFoundException(String s) {
        super(s);
    }

    public ResouseNotFoundException(){
        super("resource not found");
    }
}
