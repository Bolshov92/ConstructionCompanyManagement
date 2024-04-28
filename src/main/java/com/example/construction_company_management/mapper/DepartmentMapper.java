package com.example.construction_company_management.mapper;

import com.example.construction_company_management.dto.DepartmentAfterCreationDto;
import com.example.construction_company_management.dto.DepartmentCreateDto;
import com.example.construction_company_management.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentMapper {

    @Mapping(target = "depName", source = "depName")
    public Department toEntity(DepartmentCreateDto departmentCreateDto);

    @Mapping(target = "departmentId", source = "depName")
    public DepartmentAfterCreationDto toDo(Department departmentAfterCreation);

}
