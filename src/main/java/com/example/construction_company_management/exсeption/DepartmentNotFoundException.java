package com.example.construction_company_management.exсeption;

/**
 * Exception indicating that a department is not found in the system.
 */
public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
