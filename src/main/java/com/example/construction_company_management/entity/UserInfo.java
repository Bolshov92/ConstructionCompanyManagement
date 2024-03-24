package com.example.construction_company_management.entity;

import java.util.Set;
import java.util.UUID;

public class UserInfo {
    private UUID userId;
    private UUID accountId;
    private String userName;
    private String password;
    private String phoneNumber;
    private User user;
    //    private Account accountId; todo
    private Set<Role> roleSet;
}
