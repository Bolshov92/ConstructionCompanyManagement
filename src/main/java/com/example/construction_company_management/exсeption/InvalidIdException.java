package com.example.construction_company_management.exсeption;

/**
 * Exception thrown when an invalid ID is encountered.
 */

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String message) {
        super(message);
    }
}
