package com.example.construction_company_management.service.impl;

import com.example.construction_company_management.entity.Employee;
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
        if(id==null){
            throw new IllegalArgumentException("Employee id is null");
        }
        return employeeRepository.getEmployeeById(id);
    }
}
