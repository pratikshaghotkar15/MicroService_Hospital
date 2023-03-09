package com.patient.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String patientNotFound) {
        super(patientNotFound);
    }

    public ResourceNotFoundException(){
        super("resource not found");
    }
}
