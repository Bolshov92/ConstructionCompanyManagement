package com.example.construction_company_management.dto;

import com.example.construction_company_management.entity.Department;
import com.example.construction_company_management.entity.Employee;
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
    String departmentName;
    Employee superWiser;
}
