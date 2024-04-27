package com.example.construction_company_management.mapper;

import com.example.construction_company_management.dto.EmployeeAfterCreationDto;
import com.example.construction_company_management.dto.EmployeeCreateDto;
import com.example.construction_company_management.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "contactInfo", source = "contactInfo")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "hireDate", source = "hireDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "department.depName", source = "departmentName")


    Employee toEntity(EmployeeCreateDto employeeCreationDto);

    @Mapping(target = "employeeId", source = "id")
    EmployeeAfterCreationDto toDto(Employee employeeAfterCreation);
}
