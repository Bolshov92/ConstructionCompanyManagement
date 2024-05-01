package com.example.construction_company_management.repository;

import com.example.construction_company_management.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByRoleName(String readOnly);
}
