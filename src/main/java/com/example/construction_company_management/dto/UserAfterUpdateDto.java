package com.example.construction_company_management.dto;

import lombok.Data;

/**
 * DTO representing the response after updating a user.
 */
@Data
public class UserAfterUpdateDto {
    String userId;
    String status = "User was updated";
}
