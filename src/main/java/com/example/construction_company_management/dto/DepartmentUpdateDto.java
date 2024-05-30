package com.example.construction_company_management.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * DTO representing the update request for a department.
 * It contains the department name to be updated.
 */
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class DepartmentUpdateDto {
    String depName;
}
