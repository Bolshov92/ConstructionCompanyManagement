package com.example.construction_company_management.service;

import com.example.construction_company_management.dto.DepartmentAfterCreationDto;
import com.example.construction_company_management.dto.DepartmentAfterUpdateDto;
import com.example.construction_company_management.dto.DepartmentCreateDto;
import com.example.construction_company_management.dto.DepartmentUpdateDto;
import com.example.construction_company_management.entity.Department;

import java.util.UUID;

public interface DepartmentService {
    Department findByDepName(String depName);

    DepartmentAfterCreationDto createDepartment(DepartmentCreateDto departmentCreateDto);

    void deleteDepartmentById(UUID id);

    DepartmentAfterUpdateDto updateDepartment(UUID id, DepartmentUpdateDto departmentUpdateDto);
}