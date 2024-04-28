package com.example.construction_company_management.service.impl;

import com.example.construction_company_management.dto.DepartmentAfterCreationDto;
import com.example.construction_company_management.dto.DepartmentAfterUpdateDto;
import com.example.construction_company_management.dto.DepartmentCreateDto;
import com.example.construction_company_management.dto.DepartmentUpdateDto;
import com.example.construction_company_management.entity.Department;
import com.example.construction_company_management.exсeption.DepartmentAlreadyExists;
import com.example.construction_company_management.exсeption.DepartmentNotFoundException;
import com.example.construction_company_management.exсeption.ErrorMessage;
import com.example.construction_company_management.mapper.DepartmentMapper;
import com.example.construction_company_management.repository.DepartmentRepository;
import com.example.construction_company_management.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public Department findByDepName(String depName) {
        Department department = departmentRepository.findByDepName(depName);
        if (department == null) {
            throw new DepartmentNotFoundException(ErrorMessage.DEPARTMENT_IS_NOT_FOUND);
        }
        return department;
    }

    @Override
    public DepartmentAfterCreationDto createDepartment(DepartmentCreateDto departmentCreateDto) {
        Department department = departmentRepository.findByDepName(departmentCreateDto.getDepName());
        if (department != null) {
            throw new DepartmentAlreadyExists(ErrorMessage.EMPLOYEE_ALREADY_EXISTS);
        }
        Department entity = departmentMapper.toEntity(departmentCreateDto);
        Department departmentAfterCreation = departmentRepository.save(entity);
        return departmentMapper.toDo(departmentAfterCreation);
    }

    @Override
    public void deleteDepartmentById(UUID id) {
        if (!departmentRepository.existsById(id)) {
            throw new DepartmentNotFoundException(ErrorMessage.DEPARTMENT_IS_NOT_FOUND);
        }
        departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentAfterUpdateDto updateDepartment(UUID id, DepartmentUpdateDto departmentUpdateDto) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isEmpty()) {
            throw new DepartmentNotFoundException(ErrorMessage.DEPARTMENT_IS_NOT_FOUND);
        }
        Department department = optionalDepartment.get();
        departmentMapper.toUpdate(departmentUpdateDto, department);
        Department updateDepartment = departmentRepository.save(department);
        return departmentMapper.afterUpdateDto(updateDepartment);
    }
}
