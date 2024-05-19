package com.example.construction_company_management.repository;

import com.example.construction_company_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findUserById(UUID id);
    User getUserById(UUID id);
}
