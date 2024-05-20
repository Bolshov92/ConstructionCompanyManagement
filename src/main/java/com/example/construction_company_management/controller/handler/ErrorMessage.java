package com.example.construction_company_management.controller.handler;

import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
public class ErrorMessage {
    String message;
    HttpStatus errorCode;
    public ErrorMessage(String message, HttpStatus errorCode){
        this.message = message;
        this.errorCode = errorCode;
    }
}
