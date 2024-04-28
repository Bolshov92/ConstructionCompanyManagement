package com.example.construction_company_management.controller;

import com.example.construction_company_management.dto.DepartmentAfterCreationDto;
import com.example.construction_company_management.dto.DepartmentAfterUpdateDto;
import com.example.construction_company_management.dto.DepartmentCreateDto;
import com.example.construction_company_management.dto.DepartmentUpdateDto;
import com.example.construction_company_management.entity.Department;
import com.example.construction_company_management.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/get/{name}")
    public Department findByDepName(@PathVariable("name") String depName) {
        return departmentService.findByDepName(depName);
    }

    @PostMapping("/create")
    public DepartmentAfterCreationDto createDepartment(@RequestBody DepartmentCreateDto departmentCreateDto) {
        return departmentService.createDepartment(departmentCreateDto);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> departmentById(@PathVariable("id") UUID id) {
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.ok("Department with id " + id + " was deleted");
    }

    @PutMapping("/update/{id}")
    public DepartmentAfterUpdateDto updateDepartment(@PathVariable("id") UUID id, @RequestBody DepartmentUpdateDto departmentUpdateDto) {
        return departmentService.updateDepartment(id, departmentUpdateDto);
    }

}
