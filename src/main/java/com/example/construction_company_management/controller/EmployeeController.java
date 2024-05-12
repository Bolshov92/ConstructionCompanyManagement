package com.example.construction_company_management.controller;

import com.example.construction_company_management.dto.*;
import com.example.construction_company_management.entity.Employee;
import com.example.construction_company_management.mapper.EmployeeMapper;
import com.example.construction_company_management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;


    @GetMapping("/get/{id}")
    public EmployeeAfterCreationDto findById(@PathVariable("id") UUID id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employeeMapper.toDto(employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") UUID id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee with id " + id + " was deleted");
    }

    @PutMapping("/update/{id}")
    public EmployeeAfterUpdateDto updateEmployee(@PathVariable("id") UUID id, @RequestBody EmployeeUpdateDto employeeUpdateDto) {
        return employeeService.updateEmployee(id, employeeUpdateDto);
    }

    @PostMapping("/create")
    public EmployeeAfterCreationDto createEmployee(@RequestBody EmployeeCreateDto employeeCreateDto) {
        return employeeService.createEmployee(employeeCreateDto);
    }

}
