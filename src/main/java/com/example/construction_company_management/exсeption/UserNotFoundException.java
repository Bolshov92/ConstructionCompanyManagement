package com.example.construction_company_management.exсeption;

/**
 * Exception indicating that a user could not be found in the system.
 */
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
