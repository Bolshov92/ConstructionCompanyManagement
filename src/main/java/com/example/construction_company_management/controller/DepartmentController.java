package com.example.construction_company_management.controller;

import com.example.construction_company_management.annotation.CreateDepartment;
import com.example.construction_company_management.annotation.DeleteDepartment;
import com.example.construction_company_management.annotation.GetDepartmentByName;
import com.example.construction_company_management.annotation.UpdateDepartment;
import com.example.construction_company_management.dto.DepartmentAfterCreationDto;
import com.example.construction_company_management.dto.DepartmentAfterUpdateDto;
import com.example.construction_company_management.dto.DepartmentCreateDto;
import com.example.construction_company_management.dto.DepartmentUpdateDto;
import com.example.construction_company_management.entity.Department;
import com.example.construction_company_management.service.DepartmentService;
import com.example.construction_company_management.validation.annotation.UuidFormatChecker;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller class handling HTTP requests related to departments.
 * Contains endpoints for creating, updating, retrieving, and deleting departments.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetDepartmentByName(path = "/get/{depName}")
    @PreAuthorize("isAuthenticated()")
    public Department findByDepName(@PathVariable("depName") String depName) {
        return departmentService.findByDepName(depName);
    }

    @CreateDepartment(path = "/create")
    public DepartmentAfterCreationDto createDepartment(@RequestBody DepartmentCreateDto departmentCreateDto) {
        return departmentService.createDepartment(departmentCreateDto);

    }

    @DeleteDepartment(path = "/delete/{id}")
    public ResponseEntity<String> departmentById(@PathVariable("id") @UuidFormatChecker String id) {
        departmentService.deleteDepartmentById(UUID.fromString(id));
        return ResponseEntity.ok("Department with id " + id + " was deleted");
    }

    @UpdateDepartment(path = "/update/{id}")
    public DepartmentAfterUpdateDto updateDepartment(@PathVariable("id") @UuidFormatChecker String id, @RequestBody DepartmentUpdateDto departmentUpdateDto) {
        return departmentService.updateDepartment(UUID.fromString(id), departmentUpdateDto);
    }
}
