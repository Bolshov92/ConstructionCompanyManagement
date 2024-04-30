package com.example.construction_company_management.dto;

import com.example.construction_company_management.entity.enums.RoleName;
import lombok.Value;

import java.util.Date;


@Value
public class UserCreateDto {
    String firstName;
    String lastName;
    Date dateOfBirth;
    Date registrationDate;
    String userName;
    String password;
    String phoneNumber;
    String roleName;
}
