DROP TABLE IF EXISTS role CASCADE ;
CREATE TABLE role
(
    role_id   BINARY(16) PRIMARY KEY,
    role_name VARCHAR(255)
);
DROP TABLE IF EXISTS user_info CASCADE ;
CREATE TABLE user_info
(
    user_id      BINARY(16) PRIMARY KEY,
    user_name    VARCHAR(255),
    password     VARCHAR(255),
    phone_number VARCHAR(20)

);

DROP TABLE IF EXISTS "user" CASCADE ;
CREATE TABLE "user"
(
    id                BINARY(16) PRIMARY KEY,
    first_name        VARCHAR(255),
    last_name         VARCHAR(255),
    date_of_birth     DATE,
    registration_date DATE,
    user_id           BINARY(16),
    role_id           BINARY(16),
    FOREIGN KEY (user_id) REFERENCES user_info (user_id),
    FOREIGN KEY (role_id) REFERENCES role (role_id)
);

DROP TABLE IF EXISTS authority CASCADE ;
CREATE TABLE authority
(
    id        BINARY(16) PRIMARY KEY,
    authority VARCHAR(255),
    role_id   BINARY(16),
    user_id   BINARY(16),
    FOREIGN KEY (role_id) REFERENCES role (role_id),
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);

DROP TABLE IF EXISTS department CASCADE ;
CREATE TABLE department
(
    id       BINARY(16) PRIMARY KEY,
    dep_name VARCHAR(255)
);

DROP TABLE IF EXISTS company CASCADE ;
CREATE TABLE company
(
    id   BINARY(16) PRIMARY KEY,
    name VARCHAR(255),
    turnover DOUBLE,
    expenses DOUBLE,
    profit DOUBLE
);

DROP TABLE IF EXISTS employee CASCADE ;
CREATE TABLE employee
(
    id            BINARY(16) PRIMARY KEY,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    contact_info  VARCHAR(255),
    age           INT,
    hire_date     DATE,
    end_date      DATE,
    department_id BINARY(16),
    supervision   BINARY(16),
    FOREIGN KEY (department_id) REFERENCES department (id),
    FOREIGN KEY (supervision) REFERENCES employee (id)
);

DROP TABLE IF EXISTS construction_project CASCADE ;
CREATE TABLE construction_project
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

DROP TABLE IF EXISTS tool CASCADE ;
CREATE TABLE tool
(
    id            BINARY(16) PRIMARY KEY,
    serial_number INT
);

DROP TABLE IF EXISTS material CASCADE ;
CREATE TABLE material
(
    id                BINARY(16) PRIMARY KEY,
    name              VARCHAR(255),
    type              VARCHAR(255),
    quantity_in_stock INT
);