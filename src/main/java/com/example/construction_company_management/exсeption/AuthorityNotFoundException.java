package com.example.construction_company_management.exсeption;

/**
 * Exception indicating that an authority could not be found in the system.
 */
public class AuthorityNotFoundException extends RuntimeException {
    public AuthorityNotFoundException(String message) {
        super(message);
    }
}
