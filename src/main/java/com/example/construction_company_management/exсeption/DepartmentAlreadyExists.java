package com.example.construction_company_management.exсeption;

public class DepartmentAlreadyExists  extends RuntimeException{
    public DepartmentAlreadyExists(String message){
        super(message);
    }
}
