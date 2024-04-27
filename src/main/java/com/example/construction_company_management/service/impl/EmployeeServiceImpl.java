package com.example.construction_company_management.service.impl;

import com.example.construction_company_management.dto.EmployeeAfterCreationDto;
import com.example.construction_company_management.dto.EmployeeAfterUpdateDto;
import com.example.construction_company_management.dto.EmployeeCreateDto;
import com.example.construction_company_management.dto.EmployeeUpdateDto;
import com.example.construction_company_management.entity.Department;
import com.example.construction_company_management.entity.Employee;
import com.example.construction_company_management.exсeption.*;
import com.example.construction_company_management.mapper.EmployeeMapper;
import com.example.construction_company_management.repository.DepartmentRepository;
import com.example.construction_company_management.repository.EmployeeRepository;
import com.example.construction_company_management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentRepository departmentRepository;


    @Override
    public Employee getEmployeeById(UUID id) {
        Employee employee = employeeRepository.getEmployeeById(id);
        if (employee == null) {
            throw new EmployeeNotExistExсeption(ErrorMessage.EMPLOYEE_NOT_EXIST);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(UUID id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeIsNotFound(ErrorMessage.EMPLOYEE_IS_NOT_FOUND);
        }
        employeeRepository.deleteById(id);
    }


    @Override
    public EmployeeAfterUpdateDto updateEmployee(UUID id, EmployeeUpdateDto employeeUpdateDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            throw new EmployeeIsNotFound(ErrorMessage.EMPLOYEE_IS_NOT_FOUND);
        }
        Employee employee = optionalEmployee.get();
        employeeMapper.toUpdate(employeeUpdateDto, employee);
        Employee updateEmployee = employeeRepository.save(employee);
        return employeeMapper.afterUpdateDto(updateEmployee);
    }


    @Override
    public EmployeeAfterCreationDto createEmployee(EmployeeCreateDto employeeCreationDto) {
        Employee employee = employeeRepository.findByLastName(employeeCreationDto.getLastName());
        if (employee != null) {
            throw new EmployeeAlreadyExists(ErrorMessage.EMPLOYEE_ALREADY_EXISTS);
        }
        String depName = employeeCreationDto.getDepName();
        Department department = departmentRepository.findByDepName(depName);
        if (department == null) {
            throw new DepartmentNotFoundException(ErrorMessage.DEPARTMENT_IS_NOT_FOUND);
        }

        Employee entity = employeeMapper.toEntity(employeeCreationDto);
        entity.setDepartment(department);
        Employee employeeAfterCreation = employeeRepository.save(entity);
        return employeeMapper.toDto(employeeAfterCreation);
    }
}