package com.nurseService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResouseNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handlerMethod(ResouseNotFoundException ex){
        Map<String,Object> m=new HashMap<>();
        m.put("message",ex.getMessage());
        m.put("success",false);
        m.put("status", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(m);
    }
}
