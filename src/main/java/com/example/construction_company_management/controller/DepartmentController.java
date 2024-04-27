package com.example.construction_company_management.controller;

import com.example.construction_company_management.entity.Department;
import com.example.construction_company_management.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/get/{name}")
    public Department findByDepName(@PathVariable("name") String depName) {
        return departmentService.findByDepName(depName);
    }
}
