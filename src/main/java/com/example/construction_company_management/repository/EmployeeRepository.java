package com.example.construction_company_management.repository;

import com.example.construction_company_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.UUID;


public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Employee getEmployeeById(UUID id);
    void deleteById(UUID id);
}
