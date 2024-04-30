package com.example.construction_company_management.service;

import com.example.construction_company_management.entity.Role;
import com.example.construction_company_management.entity.enums.RoleName;

public interface RoleService {
    Role findByRoleName(RoleName roleName);
}
