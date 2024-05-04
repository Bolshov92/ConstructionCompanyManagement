package com.example.construction_company_management.service;

import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserAfterUpdateDto;
import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.dto.UserUpdateDto;
import com.example.construction_company_management.entity.User;

import java.util.UUID;

public interface UserService {
    UserAfterCreationDto createUser(UserCreateDto userCreateDto);

    void deleteUserById(UUID id);

    UserAfterUpdateDto upDateDto(UUID id, UserUpdateDto userUpdateDto);

    User getUserById(UUID id);
}
