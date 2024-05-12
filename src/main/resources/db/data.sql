INSERT INTO authority (id, authority, role_id, user_id)
VALUES (UUID_TO_BIN('42cd0d41-8705-44fc-a7d5-fa8a0beb0540'), 'User1', NULL, null);

INSERT INTO role (role_id, role_name)
VALUES (UUID_TO_BIN('bc878cd0-6ace-44e5-947e-ea9ad03b28eb'), 'ROLE_ADMIN'),
       (UUID_TO_BIN('52796ae8-e56d-4e3d-81a4-059c22f170e7'), 'ROLE_DEFAULT_USER'),
       (UUID_TO_BIN('aee6c246-d9a5-4aff-9120-1e0e3615e127'), 'ROLE_SUPERVISOR'),
       (UUID_TO_BIN('51a7658c-3ad5-4305-bfa0-682f6ec4b9fe'), 'ROLE_PROJECT_MANAGER'),
       (UUID_TO_BIN('10240b78-88c6-4a80-87e1-ac3cbf6335a2'), 'ROLE_ACCOUNTANT'),
       (UUID_TO_BIN('c53bdcdb-1681-4785-8be1-8b1e769f3b39'), 'ROLE_DIRECTOR'),
       (UUID_TO_BIN('c58694d3-473f-4155-a1e1-81fa8f534fe7'), 'ROLE_EMPLOYEE');

INSERT INTO user_info (id, user_name, password, phone_number, user_id)
VALUES ( UUID_TO_BIN('f2165341-4c7f-4c20-af08-7d0962ac4777'),'admin', 'admin_password', '123456789', UUID_TO_BIN('0f9368f4-518f-48cb-b917-2f0f967dd41e'));

INSERT INTO users (date_of_birth, first_name, last_name, registration_date, id,user_info_id, role_id)
VALUES ('1990-01-01', 'John', 'Doe', '2024-04-29', UUID_TO_BIN('0f9368f4-518f-48cb-b917-2f0f967dd41e'),UUID_TO_BIN('f2165341-4c7f-4c20-af08-7d0962ac4777'), UUID_TO_BIN('10240b78-88c6-4a80-87e1-ac3cbf6335a2'));

INSERT INTO department (id, dep_name)
VALUES (UUID_TO_BIN('02614a58-e256-482c-9284-c188c00a7ec6'), 'Builders'),
       (UUID_TO_BIN('cb5d6730-c117-473b-9ded-d4cf57a53d75'), 'Drivers');

INSERT INTO company (id, name, turnover, expenses, profit)
VALUES (UUID_TO_BIN('21fbc398-0515-419e-8c57-3e3f21e554c4'), 'ABC Construction', 1000000.00, 800000.00, 200000.00);

INSERT INTO employee (id, first_name, last_name, contact_info, age, hire_date, end_date, department_id, role_id)
VALUES (UUID_TO_BIN('639d7bc4-9845-40aa-84c8-b0f1dced6732'), 'Alice', 'Smith', 'alice@example.com', 30, '2020-01-01',
        '2023-01-01', UUID_TO_BIN('02614a58-e256-482c-9284-c188c00a7ec6'), UUID_TO_BIN('c58694d3-473f-4155-a1e1-81fa8f534fe7')),
       (UUID_TO_BIN('a2b4f08a-734e-42c7-83e1-ccea7d50a461'), 'Jake', 'Min', 'jake@example.com', 20, '2022-01-01',
        '2023-01-01', UUID_TO_BIN('02614a58-e256-482c-9284-c188c00a7ec6'),UUID_TO_BIN('aee6c246-d9a5-4aff-9120-1e0e3615e127'));

INSERT INTO construction_project (id, project_name, address, description, startDate, endDate, manager_id, company_id)
VALUES (UUID_TO_BIN('f2fba9a3-dbc9-4c35-8c06-9b3cc4f5b244'), 'Project X', '123 Main St', 'Description of Project X',
        '2020-02-01', NULL, NULL, UUID_TO_BIN('21fbc398-0515-419e-8c57-3e3f21e554c4'));

INSERT INTO tool (id, serial_number)
VALUES (UUID_TO_BIN('8bdf32e0-0847-4bd8-8cd1-235602db6e7f'), 123456),
       (UUID_TO_BIN('26584493-f042-419b-8220-dea4bd8b3ff2'), 789012);