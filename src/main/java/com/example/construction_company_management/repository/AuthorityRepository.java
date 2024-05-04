package com.example.construction_company_management.repository;

import com.example.construction_company_management.entity.Authority;
import com.example.construction_company_management.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, UUID> {
    Authority findByAuthorityName(String name);

    Authority findByRole(Role role);
}
