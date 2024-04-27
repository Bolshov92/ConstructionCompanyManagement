package com.example.construction_company_management.service;

import com.example.construction_company_management.entity.Department;

public interface DepartmentService {
    Department findByDepName(String depName);
}