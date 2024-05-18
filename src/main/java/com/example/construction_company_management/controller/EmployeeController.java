package com.example.construction_company_management.controller;

import com.example.construction_company_management.annotation.GetEmployeeById;
import com.example.construction_company_management.dto.EmployeeAfterCreationDto;
import com.example.construction_company_management.dto.EmployeeAfterUpdateDto;
import com.example.construction_company_management.dto.EmployeeCreateDto;
import com.example.construction_company_management.dto.EmployeeUpdateDto;
import com.example.construction_company_management.entity.Employee;
import com.example.construction_company_management.mapper.EmployeeMapper;
import com.example.construction_company_management.service.EmployeeService;
import lombok.AllArgsConstructor;
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
    public Employee getEmployeeById(@PathVariable(name = "id") String id) {
        return employeeService.getEmployeeById(UUID.fromString(id));
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