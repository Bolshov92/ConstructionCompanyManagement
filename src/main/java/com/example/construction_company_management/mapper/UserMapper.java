package com.example.construction_company_management.mapper;

import com.example.construction_company_management.dto.UserAfterCreationDto;
import com.example.construction_company_management.dto.UserCreateDto;
import com.example.construction_company_management.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserAfterCreationDto userAfterCreationDto(User user);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    @Mapping(target = "registrationDate", source = "registrationDate")
    @Mapping(target = "userInfo.userName", source = "userName")
    @Mapping(target = "userInfo.password", source = "password")
    @Mapping(target = "userInfo.phoneNumber", source = "phoneNumber")
    @Mapping(target = "id", ignore = true)
    User toEntity(UserCreateDto userCreateDto);


    @Mapping(target = "userId", source = "id")
    UserAfterCreationDto toDto(User user);
}
