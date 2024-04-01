CREATE TABLE Authority
(
    id        UUID PRIMARY KEY,
    authority VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Role
(
    role_id   UUID PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE User
(
    user_id           UUID PRIMARY KEY,
    first_name        VARCHAR(255) NOT NULL,
    last_name         VARCHAR(255) NOT NULL,
    date_of_birth     DATE,
    registration_date DATE
);

CREATE TABLE UserInfo
(
    user_id      UUID PRIMARY KEY,
    user_name    VARCHAR(255) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User (user_id)
);

CREATE TABLE Company
(
    id   UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    turnover DOUBLE,
    expenses DOUBLE,
    profit DOUBLE
);

CREATE TABLE Department
(
    id         UUID PRIMARY KEY,
    projects   TEXT,
    company_id UUID NOT NULL,
    FOREIGN KEY (company_id) REFERENCES Company (id)
);

CREATE TABLE Material
(
    id                UUID PRIMARY KEY,
    name              VARCHAR(255) NOT NULL,
    type              VARCHAR(255),
    quantity_in_stock INT          NOT NULL
);

CREATE TABLE Tool
(
    id            UUID PRIMARY KEY,
    serial_number INT UNIQUE
);

CREATE TABLE ConstructionProject
(
    id              UUID PRIMARY KEY,
    project_name    VARCHAR(255) NOT NULL,
    address         VARCHAR(255) NOT NULL,
    description     TEXT,
    project_manager UUID,
    start_date      DATE,
    end_date        DATE,
    company_id      UUID         NOT NULL,
    FOREIGN KEY (project_manager) REFERENCES Employee (id),
    FOREIGN KEY (company_id) REFERENCES Company (id)
);

CREATE TABLE Employee
(
    id            UUID PRIMARY KEY,
    first_name    VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    contact_info  VARCHAR(255) NOT NULL,
    age           INT,
    supervision   UUID,
    hire_date     DATE,
    end_date      DATE,
    department_id UUID,
    FOREIGN KEY (department_id) REFERENCES Department (id)
);

CREATE TABLE Role_Authority
(
    role_id      UUID,
    authority_id UUID,
    PRIMARY KEY (role_id, authority_id),
    FOREIGN KEY (role_id) REFERENCES Role (role_id),
    FOREIGN KEY (authority_id) REFERENCES Authority (id)
);