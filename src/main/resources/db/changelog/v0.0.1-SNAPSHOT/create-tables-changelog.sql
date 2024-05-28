DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS construction_project;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS authority;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_info;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS department;

CREATE TABLE IF NOT EXISTS role
(
    role_id   BINARY(16) PRIMARY KEY,
    role_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS user_info
(
    id           BINARY(16) PRIMARY KEY,
    user_name    VARCHAR(255),
    password     VARCHAR(255),
    phone_number VARCHAR(20),
    user_id      BINARY(16)
);

CREATE TABLE IF NOT EXISTS users
(
    id                BINARY(16) PRIMARY KEY,
    first_name        VARCHAR(255),
    last_name         VARCHAR(255),
    date_of_birth     DATE,
    registration_date DATE,
    user_info_id      BINARY(16),
    role_id           BINARY(16),
    FOREIGN KEY (user_info_id) REFERENCES user_info (id),
    FOREIGN KEY (role_id) REFERENCES role (role_id)
);

CREATE TABLE IF NOT EXISTS authority
(
    id        BINARY(16) PRIMARY KEY,
    authority VARCHAR(255),
    role_id   BINARY(16),
    user_id   BINARY(16),
    FOREIGN KEY (role_id) REFERENCES role (role_id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS department
(
    id       BINARY(16) PRIMARY KEY,
    dep_name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS company
(
    id       BINARY(16) PRIMARY KEY,
    name     VARCHAR(255) NOT NULL UNIQUE,
    turnover DOUBLE       NOT NULL,
    expenses DOUBLE       NOT NULL,
    profit   DOUBLE       NOT NULL
);

CREATE TABLE IF NOT EXISTS employee
(
    id            BINARY(16) PRIMARY KEY,
    first_name    VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    contact_info  VARCHAR(255) NOT NULL,
    age           INT          NOT NULL,
    hire_date     DATE         NOT NULL,
    end_date      DATE,
    department_id BINARY(16)   NOT NULL,
    role_id       BINARY(16)   NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department (id),
    FOREIGN KEY (role_id) REFERENCES role (role_id)
);

CREATE TABLE IF NOT EXISTS construction_project
(
    id           BINARY(16) PRIMARY KEY,
    project_name VARCHAR(255) NOT NULL,
    address      VARCHAR(255) NOT NULL,
    description  VARCHAR(255),
    startDate    DATE         NOT NULL,
    endDate      DATE,
    manager_id   BINARY(16),
    company_id   BINARY(16)   NOT NULL,
    FOREIGN KEY (manager_id) REFERENCES employee (id),
    FOREIGN KEY (company_id) REFERENCES company (id)
);

CREATE TABLE IF NOT EXISTS material
(
    id                BINARY(16) PRIMARY KEY,
    name              VARCHAR(255) NOT NULL,
    type              VARCHAR(255) NOT NULL,
    quantity_in_stock INT          NOT NULL
);