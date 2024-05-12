
INSERT INTO role (role_id, role_name)
VALUES (CAST('bc878cd0-6ace-44e5-947e-ea9ad03b28eb' AS UUID), 'ROLE_ADMIN'),
       (CAST('52796ae8-e56d-4e3d-81a4-059c22f170e7' AS UUID), 'ROLE_DEFAULT_USER'),
       (CAST('aee6c246-d9a5-4aff-9120-1e0e3615e127' AS UUID), 'ROLE_SUPERVISOR'),
       (CAST('51a7658c-3ad5-4305-bfa0-682f6ec4b9fe' AS UUID), 'ROLE_PROJECT_MANAGER'),
       (CAST('10240b78-88c6-4a80-87e1-ac3cbf6335a2' AS UUID), 'ROLE_ACCOUNTANT'),
       (CAST('c53bdcdb-1681-4785-8be1-8b1e769f3b39' AS UUID), 'ROLE_DIRECTOR'),
       (CAST('c58694d3-473f-4155-a1e1-81fa8f534fe7' AS UUID), 'ROLE_EMPLOYEE');



INSERT INTO user_info (id, user_name, password, phone_number, user_id)
VALUES (CAST('f2165341-4c7f-4c20-af08-7d0962ac4777' AS UUID),'admin', 'admin_password', '123456789', CAST('0f9368f4-518f-48cb-b917-2f0f967dd41e' AS UUID));

INSERT INTO users (date_of_birth, first_name, last_name, registration_date, id, user_info_id, role_id)
VALUES ('1990-01-01', 'John', 'Doe', '2024-04-29', CAST('0f9368f4-518f-48cb-b917-2f0f967dd41e'AS UUID),CAST('f2165341-4c7f-4c20-af08-7d0962ac4777'AS UUID), CAST('10240b78-88c6-4a80-87e1-ac3cbf6335a2' AS UUID));

INSERT INTO department (id, dep_name)
VALUES (CAST('02614a58-e256-482c-9284-c188c00a7ec6' AS UUID), 'Builders'),
       (CAST('cb5d6730-c117-473b-9ded-d4cf57a53d75' AS UUID), 'Drivers');

INSERT INTO company (id, name, turnover, expenses, profit)
VALUES (CAST('21fbc398-0515-419e-8c57-3e3f21e554c4' AS UUID), 'ABC Construction', 1000000.00, 800000.00, 200000.00);

INSERT INTO employee (id, first_name, last_name, contact_info, age, hire_date, end_date, department_id, role_id)
VALUES (CAST('639d7bc4-9845-40aa-84c8-b0f1dced6732' AS UUID), 'Alice', 'Smith', 'alice@example.com', 30, '2020-01-01',
        '2023-01-01', CAST('02614a58-e256-482c-9284-c188c00a7ec6' AS UUID), CAST('c58694d3-473f-4155-a1e1-81fa8f534fe7' AS UUID)),
       (CAST('a2b4f08a-734e-42c7-83e1-ccea7d50a461' AS UUID), 'Jake', 'Min', 'jake@example.com', 20, '2022-01-01',
        '2023-01-01', CAST('02614a58-e256-482c-9284-c188c00a7ec6' AS UUID),CAST('aee6c246-d9a5-4aff-9120-1e0e3615e127' AS UUID));

INSERT INTO construction_project (id, project_name, address, description, startDate, endDate, manager_id, company_id)
VALUES (CAST('f2fba9a3-dbc9-4c35-8c06-9b3cc4f5b244' AS UUID), 'Project X', '123 Main St', 'Description of Project X',
        '2020-02-01', NULL, NULL, CAST('21fbc398-0515-419e-8c57-3e3f21e554c4' AS UUID));

INSERT INTO tool (id, serial_number)
VALUES (CAST('8bdf32e0-0847-4bd8-8cd1-235602db6e7f' AS UUID), 123456),
       (CAST('26584493-f042-419b-8220-dea4bd8b3ff2' AS UUID), 789012);

INSERT INTO authority (id, authority, role_id, user_id)
VALUES (CAST('42cd0d41-8705-44fc-a7d5-fa8a0beb0540' AS UUID), 'ROLE_SUPERVISOR', CAST('aee6c246-d9a5-4aff-9120-1e0e3615e127' AS UUID), CAST('0f9368f4-518f-48cb-b917-2f0f967dd41e' AS UUID));