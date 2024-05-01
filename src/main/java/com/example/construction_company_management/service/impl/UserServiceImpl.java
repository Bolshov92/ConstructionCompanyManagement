package com.example.construction_company_management.service.impl;

import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.entity.Authority;
import com.example.construction_company_management.entity.Role;
import com.example.construction_company_management.entity.User;
import com.example.construction_company_management.entity.UserInfo;
import com.example.construction_company_management.entity.enums.RoleName;
import com.example.construction_company_management.exсeption.ErrorMessage;
import com.example.construction_company_management.exсeption.UserNotFoundException;
import com.example.construction_company_management.mapper.UserMapper;
import com.example.construction_company_management.repository.AuthorityRepository;
import com.example.construction_company_management.repository.RoleRepository;
import com.example.construction_company_management.repository.UserInfoRepository;
import com.example.construction_company_management.repository.UserRepository;
import com.example.construction_company_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
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

        RoleName roleName = RoleName.valueOf(userCreateDto.getRoleName());
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

        authority.setAuthorityName(userCreateDto.getRoleName());
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
}
