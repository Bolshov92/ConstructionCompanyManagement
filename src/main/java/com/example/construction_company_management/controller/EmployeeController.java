package com.example.construction_company_management.controller;

import com.example.construction_company_management.entity.Employee;
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


    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable("id") UUID id) {
        return employeeService.getEmployeeById(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") UUID id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee with id " + id + "deleted");
    }
}
