package com.example.construction_company_management.controller;

import com.example.construction_company_management.annotation.*;
import com.example.construction_company_management.dto.EmployeeAfterCreationDto;
import com.example.construction_company_management.dto.EmployeeAfterUpdateDto;
import com.example.construction_company_management.dto.EmployeeCreateDto;
import com.example.construction_company_management.dto.EmployeeUpdateDto;
import com.example.construction_company_management.entity.Employee;
import com.example.construction_company_management.mapper.EmployeeMapper;
import com.example.construction_company_management.service.EmployeeService;
import com.example.construction_company_management.validation.annotation.UuidFormatChecker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetEmployeeById(path = "/get/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") @UuidFormatChecker UUID id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteEmployee(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") @UuidFormatChecker  UUID id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee with id " + id + " was deleted");

    }

    @UpdateEmployee(path = "/update/{id}")
    public EmployeeAfterUpdateDto updateEmployee(@PathVariable("id") @UuidFormatChecker UUID id, @RequestBody EmployeeUpdateDto employeeUpdateDto) {
        return employeeService.updateEmployee(id, employeeUpdateDto);
    }

    @CreateEmployee(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeAfterCreationDto createEmployee(@RequestBody EmployeeCreateDto employeeCreateDto) {
        return employeeService.createEmployee(employeeCreateDto);
    }
}