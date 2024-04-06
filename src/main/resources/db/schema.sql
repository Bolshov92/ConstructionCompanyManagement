-- Вставка данных в таблицу 'authority'
INSERT INTO authority (id, authority)
VALUES ('1', 'ROLE_ADMIN'),
       ('2', 'ROLE_USER');

-- Вставка данных в таблицу 'roles'
INSERT INTO roles (role_id, role_name)
VALUES ('1', 'Administrator'),
       ('2', 'User');

-- Вставка данных в таблицу 'user_info'
INSERT INTO user_info (user_id, user_name, password, phone_number)
VALUES ('1', 'admin', 'admin_password', '123456789');

-- Вставка данных в таблицу 'user'
INSERT INTO user (user_id, first_name, last_name, date_of_birth, registrationDate)
VALUES ('1', 'John', 'Doe', '1990-01-01', '2020-01-01');

-- Вставка данных в таблицу 'department'
INSERT INTO department (id, projects)
VALUES ('1', 'Project A'),
       ('2', 'Project B');

-- Вставка данных в таблицу 'company'
INSERT INTO company (id, name, turnover, expenses, profit)
VALUES ('1', 'ABC Construction', 1000000.00, 800000.00, 200000.00);

-- Вставка данных в таблицу 'employee'
INSERT INTO employee (id, first_name, last_name, contact_info, age, hireDate, endDate, department_id)
VALUES ('1', 'Alice', 'Smith', 'alice@example.com', 30, '2020-01-01', NULL, '1');

-- Вставка данных в таблицу 'construction_project'
INSERT INTO construction_project (id, project_name, address, description, startDate, endDate, manager_id, company_id)
VALUES ('1', 'Project X', '123 Main St', 'Description of Project X', '2020-02-01', '2021-01-01', '1', '1');

-- Вставка данных в таблицу 'tool'
INSERT INTO tool (id, serial_number)
VALUES ('1', 123456),
       ('2', 789012);

-- Вставка данных в таблицу 'material'
INSERT INTO material (id, name, type, quantity_in_stock)
VALUES ('1', 'Bricks', 'Building Material', 1000),
       ('2', 'Concrete', 'Building Material', 500);