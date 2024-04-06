INSERT INTO authority (id, authority)
VALUES ('a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 'ROLE_ADMIN'),
       ('b2c3d4e5-f6g7-h8i9-j012-23456789abcd', 'ROLE_USER');

-- Вставка данных в таблицу 'roles'
INSERT INTO roles (role_id, role_name)
VALUES ('a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 'Administrator'),
       ('b2c3d4e5-f6g7-h8i9-j012-23456789abcd', 'User');

-- Вставка данных в таблицу 'user_info'
INSERT INTO user_info (user_id, user_name, password, phone_number)
VALUES ('a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 'admin', 'admin_password', '123456789');

-- Вставка данных в таблицу 'user'
INSERT INTO user (user_id, first_name, last_name, date_of_birth, registrationDate)
VALUES ('a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 'John', 'Doe', '1990-01-01', '2020-01-01');

-- Вставка данных в таблицу 'department'
INSERT INTO department (id, projects)
VALUES ('a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 'Project A'),
       ('b2c3d4e5-f6g7-h8i9-j012-23456789abcd', 'Project B');

-- Вставка данных в таблицу 'company'
INSERT INTO company (id, name, turnover, expenses, profit)
VALUES ('a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 'ABC Construction', 1000000.00, 800000.00, 200000.00);

-- Вставка данных в таблицу 'employee'
INSERT INTO employee (id, first_name, last_name, contact_info, age, hireDate, endDate, department_id)
VALUES ('a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 'Alice', 'Smith', 'alice@example.com', 30, '2020-01-01', NULL,
        'a1b2c3d4-e5f6-g7h8-i9j0-123456789abc');

-- Вставка данных в таблицу 'construction_project'
INSERT INTO construction_project (id, project_name, address, description, startDate, endDate, manager_id, company_id)
VALUES ('a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 'Project X', '123 Main St', 'Description of Project X', '2020-02-01',
        '2021-01-01', 'a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 'a1b2c3d4-e5f6-g7h8-i9j0-123456789abc');

-- Вставка данных в таблицу 'tool'
INSERT INTO tool (id, serial_number)
VALUES ('a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 123456),
       ('b2c3d4e5-f6g7-h8i9-j012-23456789abcd', 789012);

-- Вставка данных в таблицу 'material'
INSERT INTO material (id, name, type, quantity_in_stock)
VALUES ('a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 'Bricks', 'Building Material', 1000),
       ('b2c3d4e5-f6g7-h8i9-j012-23456789abcd', 'Concrete', 'Building Material', 500);