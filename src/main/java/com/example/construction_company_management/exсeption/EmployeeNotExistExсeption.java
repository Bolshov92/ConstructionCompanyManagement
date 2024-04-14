package com.example.construction_company_management.exсeption;

public class EmployeeNotExistExсeption extends RuntimeException {
    public EmployeeNotExistExсeption(String message) {
        super(message);
    }
}
