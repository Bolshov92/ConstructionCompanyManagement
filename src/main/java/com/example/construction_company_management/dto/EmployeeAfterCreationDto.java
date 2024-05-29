package com.example.construction_company_management.dto;

import lombok.Data;

/**
 * DTO representing the response after creating an employee.
 */
@Data
public class EmployeeAfterCreationDto {
    private String employeeId;
    private String status = "EMPLOYEE Created";
}
