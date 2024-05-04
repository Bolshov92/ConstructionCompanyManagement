package com.example.construction_company_management.exсeption;

public class AuthorityIsFoundException extends RuntimeException {
    public AuthorityIsFoundException(String message) {
        super(message);
    }
}
