package com.example.construction_company_management.exсeption;

/**
 * Exception indicating that an attempt was made to create a user that already exists in the system.
 */
public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
