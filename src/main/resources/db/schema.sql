CREATE TABLE authority
(
    id        CHAR(36) PRIMARY KEY,
    authority VARCHAR(255) NOT NULL UNIQUE
);


CREATE TABLE roles
(
    role_id   CHAR(36) PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL UNIQUE
);


CREATE TABLE user_info
(
    user_id      CHAR(36) PRIMARY KEY,
    user_name    VARCHAR(255) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20)  NOT NULL UNIQUE
);


CREATE TABLE user
(
    user_id          CHAR(36) PRIMARY KEY,
    first_name       VARCHAR(255) NOT NULL,
    last_name        VARCHAR(255) NOT NULL,
    date_of_birth    DATE,
    registrationDate DATE,
    FOREIGN KEY (user_id) REFERENCES user_info (user_id)
);


CREATE TABLE department
(
    id       CHAR(36) PRIMARY KEY,
    projects VARCHAR(255) NOT NULL
);


CREATE TABLE company
(
    id   CHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    turnover DOUBLE NOT NULL,
    expenses DOUBLE NOT NULL,
    profit DOUBLE NOT NULL
);


CREATE TABLE employee
(
    id            CHAR(36) PRIMARY KEY,
    first_name    VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    contact_info  VARCHAR(255) NOT NULL UNIQUE,
    age           INT          NOT NULL,
    hireDate      DATE         NOT NULL,
    endDate       DATE,
    department_id CHAR(36),
    supervision   CHAR(36),
    FOREIGN KEY (department_id) REFERENCES department (id),
    FOREIGN KEY (supervision) REFERENCES employee (id)
);


CREATE TABLE construction_project
(
    id           CHAR(36) PRIMARY KEY,
    project_name VARCHAR(255) NOT NULL,
    address      VARCHAR(255) NOT NULL,
    description  VARCHAR(255) NOT NULL,
    startDate    DATE         NOT NULL,
    endDate      DATE         NOT NULL,
    manager_id   CHAR(36),
    company_id   CHAR(36),
    FOREIGN KEY (manager_id) REFERENCES employee (id),
    FOREIGN KEY (company_id) REFERENCES company (id)
);


CREATE TABLE tool
(
    id            CHAR(36) PRIMARY KEY,
    serial_number INT NOT NULL UNIQUE
);


CREATE TABLE material
(
    id                CHAR(36) PRIMARY KEY,
    name              VARCHAR(255) NOT NULL,
    type              VARCHAR(255) NOT NULL,
    quantity_in_stock INT          NOT NULL
);