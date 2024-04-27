package com.example.construction_company_management.dto;

import lombok.Data;

@Data
public class EmployeeAfterUpdateDto {
    private String id;
    private String status = "Employee was updated";

}
