package com.example.construction_company_management.service;

import com.example.construction_company_management.entity.Employee;

import java.util.UUID;

public interface EmployeeService {
    Employee getEmployeeById(UUID id);

    void deleteEmployeeById(UUID id);

    void updateEmployee(UUID id, Employee employeeDetails);

    void createEmployee(Employee employee);
}
