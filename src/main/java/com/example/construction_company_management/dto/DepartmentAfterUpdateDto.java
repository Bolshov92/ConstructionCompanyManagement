package com.example.construction_company_management.dto;

import lombok.Data;

@Data
public class DepartmentAfterUpdateDto {
    String departmentId;
    String status = "Department was updated";
}
