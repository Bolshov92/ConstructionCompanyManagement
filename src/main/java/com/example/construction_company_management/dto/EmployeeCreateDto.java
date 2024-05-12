package com.example.construction_company_management.dto;

import lombok.Value;

import java.time.LocalDate;

@Value
public class EmployeeCreateDto {
    String firstName;
    String lastName;
    String contactInfo;
    int age;
    LocalDate hireDate;
    LocalDate endDate;
    String depName;
    String roleName;
}
