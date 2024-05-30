package com.example.construction_company_management.dto;

import lombok.Value;

import java.time.LocalDate;

/**
 * DTO class representing the data needed to update an existing employee.
 */
@Value
public class EmployeeUpdateDto {
    String firstName;
    String lastName;
    String contactInfo;
    int age;
    LocalDate hireDate;
    LocalDate endDate;
    String depName;
    String roleName;
}
