package com.example.construction_company_management.service.impl;

import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.entity.User;
import com.example.construction_company_management.entity.UserInfo;
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

        User user = new User();
        user.setUserInfo(savedUserInfo);
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setDateOfBirth(userCreateDto.getDateOfBirth());
        user.setRegistrationDate(new Date());
        user.setUserInfo(savedUserInfo);

        User savedUser = userRepository.save(user);
//        Role userRole = roleRepository.findByRoleName("ROLE_USER");
//        if(userRole == null){
//            userRole = new Role();
//            userRole.setRoleName("USER");
//            userRole = roleRepository.save(userRole);
//        }
//        Authority authority = new Authority();
//        authority.setUser(savedUser);
//        authority.setRole(userRole);
//        authorityRepository.save(authority);

        return userMapper.toDto(savedUser);
    }

    @Override
    public void deleteUserById(UUID id) {
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(ErrorMessage.USER_IS_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }
}
