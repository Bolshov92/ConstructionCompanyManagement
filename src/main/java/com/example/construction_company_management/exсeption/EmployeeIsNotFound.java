package com.example.construction_company_management.exсeption;

/**
 * Exception indicating that an employee is not found in the system.
 */
public class EmployeeIsNotFound extends RuntimeException {
    public EmployeeIsNotFound(String message) {
        super(message);
    }
}
