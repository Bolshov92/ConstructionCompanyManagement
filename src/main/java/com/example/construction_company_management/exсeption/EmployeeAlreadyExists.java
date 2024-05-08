package com.example.construction_company_management.exсeption;

public class EmployeeAlreadyExists extends RuntimeException {
    public EmployeeAlreadyExists(String message) {
        super(message);
    }
}
