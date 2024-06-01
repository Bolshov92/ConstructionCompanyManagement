package com.example.construction_company_management.mapper;

import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserAfterUpdateDto;
import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.entity.Authority;
import com.example.construction_company_management.entity.Role;
import com.example.construction_company_management.entity.User;
import com.example.construction_company_management.entity.UserInfo;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Mapper interface for converting between User entity and its corresponding DTO.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    UserAfterCreationDto userAfterCreationDto(User user);

    default Role map(String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        return role;
    }

    @Mapping(target = "firstName", source = "userCreateDto.firstName")
    @Mapping(target = "lastName", source = "userCreateDto.lastName")
    @Mapping(target = "dateOfBirth", source = "userCreateDto.dateOfBirth")
    @Mapping(target = "registrationDate", source = "userCreateDto.registrationDate")
    @Mapping(target = "userInfo.userName", source = "userCreateDto.userName")
    @Mapping(target = "userInfo.password", source = "userCreateDto.password")
    @Mapping(target = "userInfo.phoneNumber", source = "userCreateDto.phoneNumber")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", source = "userCreateDto.roleName")
    User toEntity(UserCreateDto userCreateDto);




@Mapping(target = "userId", source = "id")
UserAfterCreationDto toDto(User user);

UserAfterUpdateDto afterUpdate(User afterUpdateUser);
    @AfterMapping
    default void generateUserInfoFromGenerateDto(@MappingTarget User user, UserCreateDto userCreateDto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userCreateDto.getFirstName());
        userInfo.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        userInfo.setPhoneNumber(userCreateDto.getPhoneNumber());
        user.setUserInfo(userInfo);
        userInfo.setUser(user);


        Role role = new Role();
        role.setRoleName(userCreateDto.getRoleName());
        user.setRole(role);

        Authority authority = new Authority();
        authority.setAuthorityName(userCreateDto.getRoleName());
        authority.setUser(user);
        user.getAuthorities().add(authority);
    }
}

