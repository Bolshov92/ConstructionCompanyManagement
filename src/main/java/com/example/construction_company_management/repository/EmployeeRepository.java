package com.example.construction_company_management.repository;

import com.example.construction_company_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Employee getEmployeeById(UUID id);

    Employee findByLastName(String lastName);
}
