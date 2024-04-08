CREATE TABLE authority
(
    id        CHAR(36) PRIMARY KEY,
    authority VARCHAR(255)
);


CREATE TABLE roles
(
    role_id   CHAR(36) PRIMARY KEY,
    role_name VARCHAR(255)
);


CREATE TABLE user_info
(
    user_id      CHAR(36) PRIMARY KEY,
    user_name    VARCHAR(255),
    password     VARCHAR(255),
    phone_number VARCHAR(20) NOT NULL UNIQUE
);


CREATE TABLE user
(
    user_id          CHAR(36) PRIMARY KEY,
    first_name       VARCHAR(255),
    last_name        VARCHAR(255),
    date_of_birth    DATE,
    registrationDate DATE,
    FOREIGN KEY (user_id) REFERENCES user_info (user_id)
);


CREATE TABLE department
(
    id       CHAR(36) PRIMARY KEY,
    projects VARCHAR(255)
);


CREATE TABLE company
(
    id   CHAR(36) PRIMARY KEY,
    name VARCHAR(255),
    turnover DOUBLE,
    expenses DOUBLE,
    profit DOUBLE
);


CREATE TABLE employee
(
    id            CHAR(36) PRIMARY KEY,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    contact_info  VARCHAR(255),
    age           INT,
    hireDate      DATE,
    endDate       DATE,
    department_id CHAR(36),
    supervision   CHAR(36),
    FOREIGN KEY (department_id) REFERENCES department (id),
    FOREIGN KEY (supervision) REFERENCES employee (id)
);


CREATE TABLE construction_project
(
    id           CHAR(36) PRIMARY KEY,
    project_name VARCHAR(255),
    address      VARCHAR(255),
    description  VARCHAR(255),
    startDate    DATE,
    endDate      DATE,
    manager_id   CHAR(36),
    company_id   CHAR(36),
    FOREIGN KEY (manager_id) REFERENCES employee (id),
    FOREIGN KEY (company_id) REFERENCES company (id)
);


CREATE TABLE tool
(
    id            CHAR(36) PRIMARY KEY,
    serial_number INT
);


CREATE TABLE material
(
    id                CHAR(36) PRIMARY KEY,
    name              VARCHAR(255),
    type              VARCHAR(255),
    quantity_in_stock INT
);