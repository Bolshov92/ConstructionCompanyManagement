CREATE TABLE Authority
(
    id        CHAR(36) PRIMARY KEY,
    authority VARCHAR(255)
);

CREATE TABLE Role
(
    role_id   CHAR(36) PRIMARY KEY,
    role_name VARCHAR(255)
);

CREATE TABLE User
(
    user_id           CHAR(36) PRIMARY KEY,
    first_name        VARCHAR(255),
    last_name         VARCHAR(255),
    date_of_birth     DATE,
    registration_date DATE
);

CREATE TABLE UserInfo
(
    user_id      CHAR(36) PRIMARY KEY,
    user_name    VARCHAR(255),
    password     VARCHAR(255),
    phone_number VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES User (user_id)
);

CREATE TABLE Company
(
    id   CHAR(36) PRIMARY KEY,
    name VARCHAR(255),
    turnover DOUBLE,
    expenses DOUBLE,
    profit DOUBLE
);

CREATE TABLE Department
(
    id         CHAR(36) PRIMARY KEY,
    projects   TEXT,
    company_id CHAR(36),
    FOREIGN KEY (company_id) REFERENCES Company (id)
);

CREATE TABLE Employee
(
    id            CHAR(36) PRIMARY KEY,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    contact_info  VARCHAR(255),
    age           INT,
    supervision   CHAR(36),
    hire_date     DATE,
    end_date      DATE,
    department_id CHAR(36),
    FOREIGN KEY (department_id) REFERENCES Department (id)
);

CREATE TABLE Role_Authority
(
    role_id      CHAR(36),
    authority_id CHAR(36),
    PRIMARY KEY (role_id, authority_id),
    FOREIGN KEY (role_id) REFERENCES Role (role_id),
    FOREIGN KEY (authority_id) REFERENCES Authority (id)
);

CREATE TABLE ConstructionProject
(
    id              CHAR(36) PRIMARY KEY,
    project_name    VARCHAR(255),
    address         VARCHAR(255),
    description     TEXT,
    project_manager CHAR(36),
    start_date      DATE,
    end_date        DATE,
    company_id      CHAR(36),
    FOREIGN KEY (project_manager) REFERENCES Employee (id),
    FOREIGN KEY (company_id) REFERENCES Company (id)
);

CREATE TABLE Material
(
    id                CHAR(36) PRIMARY KEY,
    name              VARCHAR(255),
    type              VARCHAR(255),
    quantity_in_stock INT
);

CREATE TABLE Tool
(
    id            CHAR(36) PRIMARY KEY,
    serial_number INT
);