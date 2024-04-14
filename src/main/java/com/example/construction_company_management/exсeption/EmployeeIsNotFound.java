package com.example.construction_company_management.exсeption;

public class EmployeeIsNotFound extends RuntimeException {
    public EmployeeIsNotFound(String message) {
        super(message);
    }
}
