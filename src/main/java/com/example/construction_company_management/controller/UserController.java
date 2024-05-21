package com.example.construction_company_management.controller;

import com.example.construction_company_management.annotation.*;
import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserAfterUpdateDto;
import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.dto.UserUpdateDto;
import com.example.construction_company_management.entity.User;
import com.example.construction_company_management.exсeption.InvalidIdException;
import com.example.construction_company_management.mapper.UserMapper;
import com.example.construction_company_management.service.UserService;
import com.example.construction_company_management.validation.annotation.UuidFormatChecker;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.boot.context.properties.source.ConfigurationPropertyName.isValid;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;


    @CreateUser(path = "/create")
    public UserAfterCreationDto createUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.createUser(userCreateDto);
    }

    @DeleteUser(path = "/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") @Valid @UuidFormatChecker String id) {
        userService.deleteUserById(UUID.fromString(id));
        return ResponseEntity.ok("User with id " + id + " was deleted");
    }

    @UpdateUser(path = "/update/{id}")
    public UserAfterUpdateDto updateUser(@PathVariable("id") @UuidFormatChecker String id, @RequestBody UserUpdateDto userUpdateDto) {
        return userService.upDateDto(UUID.fromString(id), userUpdateDto);

    }

    @GetUserById(path = "/get/{id}")
    public User findById(@PathVariable("id") @UuidFormatChecker String id) {
        return userService.getUserById(UUID.fromString(id));
    }
}
