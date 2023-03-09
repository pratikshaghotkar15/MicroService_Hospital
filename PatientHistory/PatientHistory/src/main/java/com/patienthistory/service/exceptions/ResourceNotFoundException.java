package com.patienthistory.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String historyNotFoundWith) {
        super(historyNotFoundWith);


    }

    public ResourceNotFoundException(){
        super("resource not found");
    }
}
