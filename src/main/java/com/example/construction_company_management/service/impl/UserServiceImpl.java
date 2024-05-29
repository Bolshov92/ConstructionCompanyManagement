package com.example.construction_company_management.service.impl;

import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserAfterUpdateDto;
import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.dto.UserUpdateDto;
import com.example.construction_company_management.entity.Authority;
import com.example.construction_company_management.entity.Role;
import com.example.construction_company_management.entity.User;
import com.example.construction_company_management.entity.UserInfo;
import com.example.construction_company_management.entity.enums.RoleName;
import com.example.construction_company_management.exсeption.*;
import com.example.construction_company_management.mapper.UserMapper;
import com.example.construction_company_management.repository.AuthorityRepository;
import com.example.construction_company_management.repository.RoleRepository;
import com.example.construction_company_management.repository.UserInfoRepository;
import com.example.construction_company_management.repository.UserRepository;
import com.example.construction_company_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of the UserService interface, providing methods for managing users
 * This service handles the creation, updating, deletion, and retrieval of users.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserInfoRepository userInfoRepository;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserAfterCreationDto createUser(UserCreateDto userCreateDto) {
        Optional<User> existingUser = userRepository.findByUserInfoUserName(userCreateDto.getUserName());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with userName: " + userCreateDto.getUserName() + " already exists");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userCreateDto.getUserName());
        userInfo.setPassword(userCreateDto.getPassword());
        userInfo.setPhoneNumber(userCreateDto.getPhoneNumber());

        UserInfo savedUserInfo = userInfoRepository.save(userInfo);

        RoleName roleName = Optional.ofNullable(userCreateDto.getRoleName())
                .map(RoleName::valueOf)
                .orElse(RoleName.ROLE_DEFAULT_USER);

        Role role = roleRepository.findByRoleName(roleName.name());
        if (role == null) {
            role = new Role();
            role.setRoleName(roleName.name());
            role = roleRepository.save(role);
        }

        User user = new User();
        user.setUserInfo(savedUserInfo);
        user.setRole(role);
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setDateOfBirth(userCreateDto.getDateOfBirth());
        user.setRegistrationDate(new Date());
        user.setUserInfo(savedUserInfo);

        User savedUser = userRepository.save(user);

        Authority authority = new Authority();
        authority.setAuthorityName(roleName.name());
        authority.setRole(role);
        authority.setUser(user);
        authorityRepository.save(authority);

        UserAfterCreationDto userAfterCreationDto = userMapper.toDto(savedUser);
        userAfterCreationDto.setUserId(String.valueOf(savedUser.getId()));

        return userAfterCreationDto;

    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteUserById(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(ErrorMessage.USER_IS_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public UserAfterUpdateDto upDateDto(UUID id, UserUpdateDto userUpdateDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(ErrorMessage.EMPLOYEE_IS_NOT_FOUND);
        }
        User user = optionalUser.get();
        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());
        user.setDateOfBirth(userUpdateDto.getDateOfBirth());

        Role role = roleRepository.findByRoleName(user.getRole().getRoleName());
        if (role == null) {
            throw new RoleIsNotFoundException(ErrorMessage.ROLE_IS_NOT_FOUND + " with name: " + user.getRole().getRoleName());
        }

        Authority authority = authorityRepository.findByUser(user);
        if (authority == null) {
            throw new AuthorityNotFoundException(ErrorMessage.AUTHORITY_IS_NOT_FOUND + " with id: " + id);
        }

        if (!role.getRoleName().equals(userUpdateDto.getRoleName())) {
            Role newRole = roleRepository.findByRoleName(userUpdateDto.getRoleName());
            if (newRole == null) {
                throw new RoleIsNotFoundException(ErrorMessage.ROLE_IS_NOT_FOUND + " with name: " + userUpdateDto.getRoleName());
            }
            authority.setAuthorityName(newRole.getRoleName());
        }

        authorityRepository.save(authority);
        userInfoRepository.save(user.getUserInfo());
        User updatedUser = userRepository.save(user);

        UserAfterUpdateDto userAfterUpdateDto = userMapper.afterUpdate(updatedUser);
        userAfterUpdateDto.setUserId(String.valueOf(updatedUser.getId()));
        return userAfterUpdateDto;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public User getUserById(UUID id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new UserNotFoundException(ErrorMessage.USER_IS_NOT_FOUND);
        }
        return user;
    }
}
