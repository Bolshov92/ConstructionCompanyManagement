package com.example.construction_company_management.service;

import com.example.construction_company_management.dto.EmployeeAfterCreationDto;
import com.example.construction_company_management.dto.EmployeeAfterUpdateDto;
import com.example.construction_company_management.dto.EmployeeCreateDto;
import com.example.construction_company_management.dto.EmployeeUpdateDto;
import com.example.construction_company_management.entity.Employee;

import java.util.UUID;

public interface EmployeeService {
    Employee getEmployeeById(UUID id);

    void deleteEmployeeById(UUID id);


    EmployeeAfterUpdateDto updateEmployee(UUID id, EmployeeUpdateDto employeeUpdateDto);

    EmployeeAfterCreationDto createEmployee(EmployeeCreateDto employeeAfterCreationDto);
}
