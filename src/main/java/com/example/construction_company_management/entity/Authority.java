package com.example.construction_company_management.entity;

import java.util.Set;
import java.util.UUID;

public class Authority {
    private UUID authorityId;
    private String authorityName;
    private Set<Role> roles;
}
