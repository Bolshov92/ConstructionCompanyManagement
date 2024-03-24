package com.example.construction_company_management.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Employee {
    private UUID id;
    private String firstName;
    private String lastName;
    private String contactInfo;
    private int age;
    private Department department;
    private Employee superVISER;
    private LocalDate hirDate;
    private LocalDate endDate;
}
