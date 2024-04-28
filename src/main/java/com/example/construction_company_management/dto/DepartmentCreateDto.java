package com.example.construction_company_management.dto;

import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true)
public class DepartmentCreateDto {
    private String depName;

}
