package com.example.construction_company_management.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) representing the response after updating an employee.
 * It contains the employee ID and a status message indicating the employee update.
 */
@Data
public class EmployeeAfterUpdateDto {
    private String id;
    private String status = "Employee was updated";

}
