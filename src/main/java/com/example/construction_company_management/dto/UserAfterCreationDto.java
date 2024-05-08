package com.example.construction_company_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAfterCreationDto {
    String userId;
    String status = "User was created";
}
