package com.example.construction_company_management.exсeption;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String message) {
        super(message);
    }
}
