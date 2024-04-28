package com.example.construction_company_management.dto;

import com.example.construction_company_management.entity.Employee;
import lombok.Value;

import java.time.LocalDate;

@Value
public class EmployeeUpdateDto {
    String firstName;
    String lastName;
    String contactInfo;
    int age;
    LocalDate endDate;
    Employee superWiser;
}
