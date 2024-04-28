package com.example.construction_company_management.controller;

import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public UserAfterCreationDto createUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.createUser(userCreateDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> userById(@PathVariable("id") UUID id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User with id " + id + " was deleted");
    }
}
