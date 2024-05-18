package com.example.construction_company_management.controller;

import com.example.construction_company_management.annotation.CreateEmployee;
import com.example.construction_company_management.annotation.DeleteEmployee;
import com.example.construction_company_management.annotation.GetEmployeeById;
import com.example.construction_company_management.annotation.UpdateEmployee;
import com.example.construction_company_management.dto.EmployeeAfterCreationDto;
import com.example.construction_company_management.dto.EmployeeAfterUpdateDto;
import com.example.construction_company_management.dto.EmployeeCreateDto;
import com.example.construction_company_management.dto.EmployeeUpdateDto;
import com.example.construction_company_management.entity.Employee;
import com.example.construction_company_management.mapper.EmployeeMapper;
import com.example.construction_company_management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetEmployeeById(path = "/get/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") String id) {
        return employeeService.getEmployeeById(UUID.fromString(id));
    }

    @DeleteEmployee(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteEmployeeById(@PathVariable("id") String id) {
        return employeeService.deleteEmployeeById(UUID.fromString(id));

    }

    @UpdateEmployee(path = "/update/{id}")
    public EmployeeAfterUpdateDto updateEmployee(@PathVariable("id") UUID id, @RequestBody EmployeeUpdateDto employeeUpdateDto) {
        return employeeService.updateEmployee(id, employeeUpdateDto);
    }

    @CreateEmployee(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeAfterCreationDto createEmployee(@RequestBody EmployeeCreateDto employeeCreateDto) {
        return employeeService.createEmployee(employeeCreateDto);
    }
}