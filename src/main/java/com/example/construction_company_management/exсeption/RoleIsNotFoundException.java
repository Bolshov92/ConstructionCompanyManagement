package com.example.construction_company_management.exсeption;

/**
 * Exception indicating that a role could not be found in the system.
 */

public class RoleIsNotFoundException  extends RuntimeException{
    public RoleIsNotFoundException(String message){
        super(message);
    }
}
