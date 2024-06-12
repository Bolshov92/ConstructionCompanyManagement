package com.example.construction_company_management.security.security_util;

public class RolesPaths {
    public static final String ADMIN = "ADMIN";
    public static final String SUPERVISOR = "SUPERVISOR";
    public static final String DIRECTOR = "DIRECTOR";
    public static final String EMPLOYEE = "EMPLOYEE";

    public static final String[] ADMIN_LIST = {
            "/user/create",
            "/user/delete/{id}",
            "/user/update/{id}",
            "/user/get/{id}",
            "/employee/create",
            "/employee/delete/{id}",
            "/employee/update/{id}",
            "/employee/get/{id}",
            "/department/get/{depName}",
            "/department/create",
            "/department/delete/{id}",
            "/department/update/{id}"
    };

    public static final String[] SUPERVISOR_LIST = {
            "/employee/create",
            "/employee/update/{id}",
            "/department/update/{id}"
    };

    public static final String[] DIRECTOR_LIST = {
            "/user/delete/{id}",
            "/user/update/{id}",
            "/employee/create",
            "/employee/delete/{id}",
            "/employee/update/{id}",
            "/department/create",
            "/department/delete/{id}",
            "/department/update/{id}"
    };
    public static final String[] EMPLOYEE_LIST = {
            "/employee/get/{id}",
            "/department/get/{depName}"
    };

}
