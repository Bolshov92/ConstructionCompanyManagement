package com.example.construction_company_management.dto;

import lombok.Value;

import java.util.Date;

@Value
public class UserUpdateDto {
    String firstName;
    String lastName;
    Date dateOfBirth;
    String userName;
    String password;
    String phoneNumber;
    String roleName;
}