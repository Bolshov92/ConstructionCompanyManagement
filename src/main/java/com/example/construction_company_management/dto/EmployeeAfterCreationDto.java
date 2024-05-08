package com.example.construction_company_management.dto;

import lombok.Data;


@Data

public class EmployeeAfterCreationDto {
    private String employeeId;
    private String status = "EMPLOYEE Created";
}
