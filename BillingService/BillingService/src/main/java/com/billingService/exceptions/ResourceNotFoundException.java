package com.billingService.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String billNotFound) {
        super(billNotFound);
    }

    public ResourceNotFoundException(){
        super("resource not found");
    }
}
