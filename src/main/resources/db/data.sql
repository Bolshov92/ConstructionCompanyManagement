INSERT INTO authority (id, authority)
VALUES ('d5b6c663-b49b-42b1-a633-ed35ea508cc0', 'User1');

INSERT INTO role (role_id, role_name)
VALUES ('d5b6c663-b49b-42b1-a633-ed35ea508cc0', 'ROLE_ADMIN'),
       ('97caae32-94dc-433c-9f6b-4098e305eed8', 'ROLE_USER');

INSERT INTO user_info (user_id, user_name, password, phone_number)
VALUES ('a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 'admin', 'admin_password', '123456789');

INSERT INTO user (user_id, first_name, last_name, date_of_birth, registrationDate)
VALUES ('a1b2c3d4-e5f6-g7h8-i9j0-123456789abc', 'John', 'Doe', '1990-01-01', '2020-01-01');

INSERT INTO department (id, projects)
VALUES ('02614a58-e256-482c-9284-c188c00a7ec6', 'Project A'),
       ('cb5d6730-c117-473b-9ded-d4cf57a53d75', 'Project B');

INSERT INTO company (id, name, turnover, expenses, profit)
VALUES ('21fbc398-0515-419e-8c57-3e3f21e554c4', 'ABC Construction', 1000000.00, 800000.00, 200000.00);

INSERT INTO employee (id, first_name, last_name, contact_info, age, hireDate, endDate, department_id)
VALUES ('639d7bc4-9845-40aa-84c8-b0f1dced6732', 'Alice', 'Smith', 'alice@example.com', 30, '2020-01-01', NULL,
        '02614a58-e256-482c-9284-c188c00a7ec6');

INSERT INTO tool (id, serial_number)
VALUES ('8bdf32e0-0847-4bd8-8cd1-235602db6e7f', 123456),
       ('26584493-f042-419b-8220-dea4bd8b3ff2', 789012);

INSERT INTO material (id, name, type, quantity_in_stock)
VALUES ('a7c5bfc6-8cba-4857-85de-403f613d5df7', 'Bricks', 'Building Material', 1000),
       ('7d5a9a4b-9185-42a4-abe2-290c45de630b', 'Concrete', 'Building Material', 500);

INSERT INTO construction_project (id, project_name, address, description, startDate, endDate, manager_id, company_id)
VALUES ('f2fba9a3-dbc9-4c35-8c06-9b3cc4f5b244', 'Project X', '123 Main St', 'Description of Project X', '2020-02-01',
        NULL, '639d7bc4-9845-40aa-84c8-b0f1dced6732', '21fbc398-0515-419e-8c57-3e3f21e554c4');