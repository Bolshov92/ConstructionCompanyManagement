package com.example.construction_company_management.entity;

import java.util.Date;
import java.util.UUID;

public class ConstructionProject {
    private UUID id;
    private String projectName;
    private String address;
    private String description;
    private Employee projectManager;
    private Date startDate;
    private Date endDate;
}
