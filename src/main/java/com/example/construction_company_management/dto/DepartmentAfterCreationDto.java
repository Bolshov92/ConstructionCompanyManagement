package com.example.construction_company_management.dto;

import lombok.Data;

/**
 * DTO representing the response after creating a department.
 * It contains the department ID and a status message indicating the department creation.
 */
@Data
public class DepartmentAfterCreationDto {
    String departmentId;
    String status = "Department was created";
}
