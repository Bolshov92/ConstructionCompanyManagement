package com.example.construction_company_management.mapper;

import com.example.construction_company_management.dto.EmployeeAfterCreationDto;
import com.example.construction_company_management.dto.EmployeeAfterUpdateDto;
import com.example.construction_company_management.dto.EmployeeCreateDto;
import com.example.construction_company_management.dto.EmployeeUpdateDto;
import com.example.construction_company_management.entity.Employee;
import org.mapstruct.*;

/**
 * Mapper interface for converting between Employee entity and its corresponding DTO.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "contactInfo", source = "contactInfo")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "hireDate", source = "hireDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "department.depName", source = "depName")
    @Mapping(target = "role.roleName", source = "roleName")
    @Mapping(target = "id", ignore = true)
    Employee toEntity(EmployeeCreateDto employeeCreationDto);

    @Mapping(target = "employeeId", source = "id")
    EmployeeAfterCreationDto toDto(Employee employee);

    @Mapping(target = "firstName", source = "employeeUpdateDto.firstName")
    @Mapping(target = "lastName", source = "employeeUpdateDto.lastName")
    @Mapping(target = "contactInfo", source = "employeeUpdateDto.contactInfo")
    @Mapping(target = "age", source = "employeeUpdateDto.age")
    @Mapping(target = "endDate", source = "employeeUpdateDto.endDate")
    @Mapping(target = "id", ignore = true)
    void toUpdate(EmployeeUpdateDto employeeUpdateDto, @MappingTarget Employee employee);

    @Mapping(target = "id", source = "id")
    EmployeeAfterUpdateDto afterUpdateDto(Employee employeeAfterUpdate);
}
