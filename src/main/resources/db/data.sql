
INSERT INTO authority (id, authority)
VALUES (UUID_TO_BIN('d5b6c663-b49b-42b1-a633-ed35ea508cc0'), 'User1');

INSERT INTO role (role_id, role_name, user_id)
VALUES (UUID_TO_BIN('d5b6c663-b49b-42b1-a633-ed35ea508cc0'), 'ROLE_ADMIN',null),
       (UUID_TO_BIN('97caae32-94dc-433c-9f6b-4098e305eed8'), 'ROLE_USER',null);

INSERT INTO user_info (user_name, password, phone_number, user_id)
VALUES ('admin','admin_password','123456789',UUID_TO_BIN('0f9368f4-518f-48cb-b917-2f0f967dd41e'));

INSERT INTO user (date_of_birth, first_name, last_name, registration_date,role_name, id, role_id)
VALUES ('1990-01-01', 'John', 'Doe', '2024-04-29','USER', UUID_TO_BIN('0f9368f4-518f-48cb-b917-2f0f967dd41e'), UUID_TO_BIN('97caae32-94dc-433c-9f6b-4098e305eed8'));

INSERT INTO department (id, dep_name)
VALUES (UUID_TO_BIN('02614a58-e256-482c-9284-c188c00a7ec6'), 'Builders'),
       (UUID_TO_BIN('cb5d6730-c117-473b-9ded-d4cf57a53d75'), 'Drivers');

INSERT INTO company (id, name, turnover, expenses, profit)
VALUES (UUID_TO_BIN('21fbc398-0515-419e-8c57-3e3f21e554c4'), 'ABC Construction', 1000000.00, 800000.00, 200000.00);

INSERT INTO employee (id, first_name, last_name, contact_info, age, hire_date, end_date, department_id)
VALUES (UUID_TO_BIN('639d7bc4-9845-40aa-84c8-b0f1dced6732'), 'Alice', 'Smith', 'alice@example.com', 30, '2020-01-01','2023-01-01',
        UUID_TO_BIN('02614a58-e256-482c-9284-c188c00a7ec6')),
       (UUID_TO_BIN('a2b4f08a-734e-42c7-83e1-ccea7d50a461'), 'Jake', 'Min', 'jake@example.com', 20, '2022-01-01','2023-01-01' ,
        UUID_TO_BIN('02614a58-e256-482c-9284-c188c00a7ec6'));

INSERT INTO construction_project (id, project_name, address, description, startDate, endDate, manager_id, company_id)
VALUES (UUID_TO_BIN('f2fba9a3-dbc9-4c35-8c06-9b3cc4f5b244'), 'Project X', '123 Main St', 'Description of Project X', '2020-02-01',
        NULL, NULL, UUID_TO_BIN('21fbc398-0515-419e-8c57-3e3f21e554c4'));

INSERT INTO tool (id, serial_number)
VALUES (UUID_TO_BIN('8bdf32e0-0847-4bd8-8cd1-235602db6e7f'), 123456),
       (UUID_TO_BIN('26584493-f042-419b-8220-dea4bd8b3ff2'), 789012);

INSERT INTO material (id, name, type, quantity_in_stock)
VALUES (UUID_TO_BIN('a7c5bfc6-8cba-4857-85de-403f613d5df7'), 'Bricks', 'Building Material', 1000),
       (UUID_TO_BIN('7d5a9a4b-9185-42a4-abe2-290c45de630b'), 'Concrete', 'Building Material', 500);
