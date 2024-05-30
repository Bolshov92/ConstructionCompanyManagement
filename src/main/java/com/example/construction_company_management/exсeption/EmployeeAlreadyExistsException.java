package com.example.construction_company_management.exсeption;

/**
 * Exception indicating that an attempt was made to create an employee that already exists in the system.
 */
public class EmployeeAlreadyExistsException extends RuntimeException {
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
