package com.example.construction_company_management.exсeption;

/**
 * Exception indicating that a department already exists in the system.
 */
public class DepartmentAlreadyExists  extends RuntimeException{
    public DepartmentAlreadyExists(String message){
        super(message);
    }
}
