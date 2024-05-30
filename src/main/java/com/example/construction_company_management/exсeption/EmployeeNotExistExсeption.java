package com.example.construction_company_management.exсeption;

/**
 * Exception thrown when attempting to access an employee that does not exist.
 */

public class EmployeeNotExistExсeption extends RuntimeException {
    public EmployeeNotExistExсeption(String message) {
        super(message);
    }
}
