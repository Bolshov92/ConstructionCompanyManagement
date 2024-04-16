package com.example.construction_company_management.service.impl;

import com.example.construction_company_management.entity.Employee;
import com.example.construction_company_management.exсeption.EmployeeIsNotFound;
import com.example.construction_company_management.exсeption.EmployeeNotExistExсeption;
import com.example.construction_company_management.exсeption.ErrorMessage;
import com.example.construction_company_management.repository.EmployeeRepository;
import com.example.construction_company_management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;


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
    public void updateEmployee(UUID id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeIsNotFound(ErrorMessage.EMPLOYEE_IS_NOT_FOUND));


        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setAge(employeeDetails.getAge());
        employee.setContactInfo(employeeDetails.getContactInfo());


        employeeRepository.save(employee);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
