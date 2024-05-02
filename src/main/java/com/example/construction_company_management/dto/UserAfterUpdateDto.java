package com.example.construction_company_management.dto;

import lombok.Data;

@Data
public class UserAfterUpdateDto {
    String userId;
    String status = "User was updated";
}
