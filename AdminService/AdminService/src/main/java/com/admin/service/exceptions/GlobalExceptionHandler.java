package com.admin.service.exceptions;

import com.admin.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //if any exception occurs in project it will be handle here
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //if exception occur this method run
    public ResponseEntity<ApiResponse> handlerResourcenotFoundException(ResourceNotFoundException exception){
        String message=exception.getMessage();
        ApiResponse response=ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        //obj build in one line through builder
        return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
