package com.example.construction_company_management.controller;

import com.example.construction_company_management.dto.DepartmentAfterCreationDto;
import com.example.construction_company_management.dto.DepartmentCreateDto;
import com.example.construction_company_management.entity.Department;
import com.example.construction_company_management.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public DepartmentAfterCreationDto createDepartment(@RequestBody DepartmentCreateDto departmentCreateDto){
        return departmentService.createDepartment(departmentCreateDto);
    }
}
