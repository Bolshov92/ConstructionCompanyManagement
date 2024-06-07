package com.example.construction_company_management.controller;

import com.example.construction_company_management.annotation.CreateUser;
import com.example.construction_company_management.annotation.DeleteUser;
import com.example.construction_company_management.annotation.GetUserById;
import com.example.construction_company_management.annotation.UpdateUser;
import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserAfterUpdateDto;
import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.dto.UserUpdateDto;
import com.example.construction_company_management.entity.User;
import com.example.construction_company_management.service.UserService;
import com.example.construction_company_management.validation.annotation.UuidFormatChecker;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class handling HTTP requests related to users.
 * Contains endpoints for creating, updating, retrieving, and deleting users.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @CreateUser(path = "/create")
    public UserAfterCreationDto createUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.createUser(userCreateDto);
    }

    @DeleteUser(path = "/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_SUPERVISOR') or hasAuthority('ROLE_DIRECTOR')")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") @Valid @UuidFormatChecker String id) {
        userService.deleteUserById(UUID.fromString(id));
        return ResponseEntity.ok("User with id " + id + " was deleted");
    }

    @UpdateUser(path = "/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_DIRECTOR')")
    public UserAfterUpdateDto updateUser(@PathVariable("id") @UuidFormatChecker String id, @RequestBody UserUpdateDto userUpdateDto) {
        return userService.upDateDto(UUID.fromString(id), userUpdateDto);

    }

    @GetUserById(path = "/get/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User findById(@PathVariable("id") @UuidFormatChecker String id) {
        return userService.getUserById(UUID.fromString(id));
    }
}
