package com.example.construction_company_management.service;

import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserCreateDto;

public interface UserService {
    UserAfterCreationDto createUser(UserCreateDto userCreateDto);
}
