package com.example.construction_company_management.dto;

import com.example.construction_company_management.entity.Employee;
import com.example.construction_company_management.entity.Role;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

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
