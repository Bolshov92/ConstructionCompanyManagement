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
import com.example.construction_company_management.service.EmployeeService;
import com.example.construction_company_management.validation.annotation.UuidFormatChecker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller class handling HTTP requests related to employees.
 * Contains endpoints for retrieving, creating, updating, and deleting employees.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetEmployeeById(path = "/get/{id}")
    @PreAuthorize("isAuthenticated()")
    public Employee getEmployeeById(@PathVariable(name = "id") @UuidFormatChecker String id) {
        return employeeService.getEmployeeById(UUID.fromString(id));
    }

    @DeleteEmployee(path = "/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_DIRECTOR')")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") @UuidFormatChecker String id) {
        employeeService.deleteEmployeeById(UUID.fromString(id));
        return ResponseEntity.ok("Employee with id " + id + " was deleted");

    }

    @UpdateEmployee(path = "/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')or hasAuthority('ROLE_SUPERVISOR') or hasAuthority('ROLE_DIRECTOR')")
    public EmployeeAfterUpdateDto updateEmployee(@PathVariable("id") @UuidFormatChecker String id, @RequestBody EmployeeUpdateDto employeeUpdateDto) {
        return employeeService.updateEmployee(UUID.fromString(id), employeeUpdateDto);
    }

    @CreateEmployee(path = "/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_SUPERVISOR') or hasAuthority('ROLE_DIRECTOR')")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeAfterCreationDto createEmployee(@RequestBody EmployeeCreateDto employeeCreateDto) {
        return employeeService.createEmployee(employeeCreateDto);
    }
}