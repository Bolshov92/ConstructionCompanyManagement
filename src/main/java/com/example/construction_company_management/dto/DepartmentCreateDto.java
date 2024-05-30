package com.example.construction_company_management.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * DTO class representing the data needed to create a new department.
 */
@Value
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class DepartmentCreateDto {
    String depName;

}
