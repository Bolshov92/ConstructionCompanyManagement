package com.example.construction_company_management.service.impl;

import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserAfterUpdateDto;
import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.dto.UserUpdateDto;
import com.example.construction_company_management.entity.*;
import com.example.construction_company_management.entity.enums.RoleName;
import com.example.construction_company_management.exсeption.AuthorityIsFoundException;
import com.example.construction_company_management.exсeption.ErrorMessage;
import com.example.construction_company_management.exсeption.RoleIsNotFoundException;
import com.example.construction_company_management.exсeption.UserNotFoundException;
import com.example.construction_company_management.mapper.UserMapper;
import com.example.construction_company_management.repository.AuthorityRepository;
import com.example.construction_company_management.repository.RoleRepository;
import com.example.construction_company_management.repository.UserInfoRepository;
import com.example.construction_company_management.repository.UserRepository;
import com.example.construction_company_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserInfoRepository userInfoRepository;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;


    @Override
    public UserAfterCreationDto createUser(UserCreateDto userCreateDto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userCreateDto.getUserName());
        userInfo.setPassword(userCreateDto.getPassword());
        userInfo.setPhoneNumber(userCreateDto.getPhoneNumber());

        UserInfo savedUserInfo = userInfoRepository.save(userInfo);

        RoleName roleName = Optional.ofNullable(userCreateDto.getRoleName())
                .map(RoleName::valueOf)
                .orElse(RoleName.DEFAULT_USER);

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
        authorityRepository.save(authority);

        UserAfterCreationDto userAfterCreationDto = userMapper.toDto(savedUser);
        userAfterCreationDto.setUserId(String.valueOf(savedUser.getId()));

        return userAfterCreationDto;

    }

    @Override
    public void deleteUserById(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(ErrorMessage.USER_IS_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserAfterUpdateDto upDateDto(UUID id, UserUpdateDto userUpdateDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(ErrorMessage.EMPLOYEE_IS_NOT_FOUND);
        }
        User user = optionalUser.get();
        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());
        user.setDateOfBirth(userUpdateDto.getDateOfBirth());

        if (userUpdateDto.getRoleName() != null) {
            RoleName roleName = RoleName.valueOf(userUpdateDto.getRoleName());
            Role role = roleRepository.findByRoleName(roleName.name());
            if (role == null) {
                throw new RoleIsNotFoundException( ErrorMessage.ROLE_IS_NOT_FOUND + " with name: " + roleName);
            }
            user.setRole(role);

            Authority authority = authorityRepository.findByAuthorityName(roleName.name());
            if (authority == null) {
                throw new AuthorityIsFoundException(ErrorMessage.AUTHORITY_IS_NOT_FOUND + " with name: " + roleName);
            }
        }

        UserInfo userInfo = user.getUserInfo();
        userInfo.setUserName(userUpdateDto.getUserName());
        userInfo.setPassword(userUpdateDto.getPassword());
        userInfo.setPhoneNumber(userUpdateDto.getPhoneNumber());
        userInfoRepository.save(userInfo);

        User updatedUser = userRepository.save(user);
        UserAfterUpdateDto userAfterUpdateDto = userMapper.afterUpdate(updatedUser);
        userAfterUpdateDto.setUserId(String.valueOf(updatedUser.getId())); // Устанавливаем user_id
        return userAfterUpdateDto;
    }
}
