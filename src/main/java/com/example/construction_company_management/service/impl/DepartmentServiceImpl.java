package com.example.construction_company_management.service.impl;

import com.example.construction_company_management.entity.Department;
import com.example.construction_company_management.exсeption.DepartmentNotFoundException;
import com.example.construction_company_management.exсeption.ErrorMessage;
import com.example.construction_company_management.repository.DepartmentRepository;
import com.example.construction_company_management.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public Department findByDepName(String depName) {
      Department department = departmentRepository.findByDepName(depName);
      if(department == null){
          throw new DepartmentNotFoundException(ErrorMessage.DEPARTMENT_IS_NOT_FOUND);
      }
      return department;
    }
}
