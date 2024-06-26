package com.example.construction_company_management.mapper;

import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserAfterUpdateDto;
import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper interface for converting between User entity and its corresponding DTO.
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "firstName", source = "userCreateDto.firstName")
    @Mapping(target = "lastName", source = "userCreateDto.lastName")
    @Mapping(target = "dateOfBirth", source = "userCreateDto.dateOfBirth")
    @Mapping(target = "registrationDate", source = "userCreateDto.registrationDate")
    @Mapping(target = "userInfo.userName", source = "userCreateDto.userName")
    @Mapping(target = "userInfo.password", source = "userCreateDto.password")
    @Mapping(target = "userInfo.phoneNumber", source = "userCreateDto.phoneNumber")
    @Mapping(target = "id", ignore = true)
    User toEntity(UserCreateDto userCreateDto);

    @Mapping(target = "userId", source = "id")
    UserAfterCreationDto toDto(User user);

    UserAfterUpdateDto afterUpdate(User afterUpdateUser);

}

