package com.example.construction_company_management.exсeption;

public class RoleIsNotFoundException  extends RuntimeException{
    public RoleIsNotFoundException(String message){
        super(message);
    }
}
