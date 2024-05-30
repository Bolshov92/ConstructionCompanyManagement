package com.example.construction_company_management.mapper;

import com.example.construction_company_management.dto.DepartmentAfterCreationDto;
import com.example.construction_company_management.dto.DepartmentAfterUpdateDto;
import com.example.construction_company_management.dto.DepartmentCreateDto;
import com.example.construction_company_management.dto.DepartmentUpdateDto;
import com.example.construction_company_management.entity.Department;
import org.mapstruct.*;

/**
 * Mapper interface for converting between Department entity and its corresponding DTO.
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    @Mapping(target = "depName", source = "depName")
    @Mapping(target = "employees", ignore = true)
    Department toEntity(DepartmentCreateDto departmentCreateDto);

    @Mapping(target = "departmentId", source = "depName")
    DepartmentAfterCreationDto toDo(Department departmentAfterCreation);

    @Mapping(target = "depName", source = "departmentUpdateDto.depName")
    @Mapping(target = "employees", ignore = true)
    void toUpdate(DepartmentUpdateDto departmentUpdateDto, @MappingTarget Department department);

    @Mapping(target = "departmentId", source = "id")
    DepartmentAfterUpdateDto afterUpdateDto(Department updateDepartment);
}
