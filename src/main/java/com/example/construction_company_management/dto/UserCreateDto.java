package com.example.construction_company_management.dto;

import lombok.Value;

import java.util.Date;

/**
 * DTO class representing the data needed to create a new user.
 */
@Value
public class UserCreateDto {
    String firstName;
    String lastName;
    Date dateOfBirth;
    Date registrationDate;
    String userName;
    String password;
    String phoneNumber;
}
