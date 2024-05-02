package com.example.construction_company_management.controller;

import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserAfterUpdateDto;
import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.dto.UserUpdateDto;
import com.example.construction_company_management.entity.Role;
import com.example.construction_company_management.entity.User;
import com.example.construction_company_management.exсeption.ErrorMessage;
import com.example.construction_company_management.exсeption.UserNotFoundException;
import com.example.construction_company_management.repository.RoleRepository;
import com.example.construction_company_management.repository.UserRepository;
import com.example.construction_company_management.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @PostMapping("/create")
    public UserAfterCreationDto createUser(@RequestBody UserCreateDto userCreateDto) {
        UserAfterCreationDto createdUser = userService.createUser(userCreateDto);
        UUID userId = UUID.fromString(createdUser.getUserId());
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Role role = user.getRole();
            role.setUser(user);
            roleRepository.save(role);
        } else {
            throw new UserNotFoundException(ErrorMessage.USER_IS_NOT_FOUND);
        }
        return createdUser;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> userById(@PathVariable("id") UUID id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User with id " + id + " was deleted");
    }

    @PutMapping("/update/{id})")
            public UserAfterUpdateDto updateUser(@PathVariable ("id")UUID id, @RequestBody UserUpdateDto userUpdateDto ) {
        return userService.upDateDto(id, userUpdateDto);

    }
}
