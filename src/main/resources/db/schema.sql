DROP TABLE IF EXISTS tool;
DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS construction_project;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_info;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS authority;

CREATE TABLE IF NOT EXISTS authority
(
    id        BINARY(16) PRIMARY KEY,
    authority VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS role
(
    role_id   BINARY(16) PRIMARY KEY,
    role_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS user_info
(
    user_id      BINARY(16) PRIMARY KEY,
    user_name    VARCHAR(255),
    password     VARCHAR(255),
    phone_number VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS user
(
    user_id          BINARY(16) PRIMARY KEY,
    first_name       VARCHAR(255),
    last_name        VARCHAR(255),
    date_of_birth    DATE,
    registrationDate DATE,
    FOREIGN KEY (user_id) REFERENCES user_info (user_id)
);

CREATE TABLE IF NOT EXISTS department
(
    id       BINARY(16) PRIMARY KEY,
    dep_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS company
(
    id   BINARY(16) PRIMARY KEY,
    name VARCHAR(255),
    turnover DOUBLE,
    expenses DOUBLE,
    profit DOUBLE
);

CREATE TABLE IF NOT EXISTS employee
(
    id           BINARY(16) PRIMARY KEY,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    contact_info  VARCHAR(255),
    age           INT,
    hire_date      DATE,
    end_date       DATE,
    department_id BINARY(16),
    supervision   BINARY(16),
    FOREIGN KEY (department_id) REFERENCES department (id),
    FOREIGN KEY (supervision) REFERENCES employee (id)
);

CREATE TABLE IF NOT EXISTS construction_project
(
    id           BINARY(16) PRIMARY KEY,
    project_name VARCHAR(255),
    address      VARCHAR(255),
    description  VARCHAR(255),
    startDate    DATE,
    endDate      DATE,
    manager_id   BINARY(16),
    company_id   BINARY(16),
    FOREIGN KEY (manager_id) REFERENCES employee (id),
    FOREIGN KEY (company_id) REFERENCES company (id)
);

CREATE TABLE IF NOT EXISTS tool
(
    id            BINARY(16) PRIMARY KEY,
    serial_number INT
);

CREATE TABLE IF NOT EXISTS material
(
    id                BINARY(16) PRIMARY KEY,
    name              VARCHAR(255),
    type              VARCHAR(255),
    quantity_in_stock INT
);
