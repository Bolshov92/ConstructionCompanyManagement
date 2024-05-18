package com.example.construction_company_management.service;

import com.example.construction_company_management.dto.*;
import com.example.construction_company_management.entity.Employee;

import java.util.UUID;

public interface EmployeeService {
    Employee getEmployeeById(UUID id);

    String deleteEmployeeById(UUID id);

    EmployeeAfterUpdateDto updateEmployee(UUID id, EmployeeUpdateDto employeeUpdateDto);

    EmployeeAfterCreationDto createEmployee(EmployeeCreateDto employeeAfterCreationDto);
}
