package com.example.construction_company_management.repository;

import com.example.construction_company_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee getEmployeeById(UUID id);
}
