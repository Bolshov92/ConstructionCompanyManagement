INSERT INTO authority (id, authority)
VALUES ('1', 'READ'),
       ('2', 'WRITE'),
       ('3', 'DELETE');

INSERT INTO roles (role_id, role_name)
VALUES ('1', 'ROLE_USER'),
       ('2', 'ROLE_ADMIN');

INSERT INTO user_info (user_id, user_name, password, phone_number)
VALUES ('1', 'user1', 'password1', '1234567890'),
       ('2', 'user2', 'password2', '0987654321');

INSERT INTO user (user_id, first_name, last_name, date_of_birth, registrationDate)
VALUES ('1', 'John', 'Doe', '1990-01-01', '2020-01-01'),
       ('2', 'Jane', 'Smith', '1995-05-05', '2020-02-01');

INSERT INTO department (id, projects)
VALUES ('1', 'Project A'),
       ('2', 'Project B');

INSERT INTO company (id, name, turnover, expenses, profit)
VALUES ('1', 'Company X', 1000000, 500000, 500000),
       ('2', 'Company Y', 2000000, 1000000, 1000000);

INSERT INTO employee (id, first_name, last_name, contact_info, age, hireDate, endDate, department_id, supervision)
VALUES ('1', 'Mark', 'Johnson', 'mark@example.com', 30, '2020-01-01', NULL, '1', NULL),
       ('2', 'Emily', 'Brown', 'emily@example.com', 35, '2019-05-01', NULL, '2', '1');

INSERT INTO construction_project (id, project_name, address, description, startDate, endDate, manager_id, company_id)
VALUES ('1', 'Project Alpha', '123 Main St', 'Description for Project Alpha', '2020-01-01', '2021-01-01', '1', '1'),
       ('2', 'Project Beta', '456 Elm St', 'Description for Project Beta', '2020-02-01', '2021-02-01', '2', '2');

INSERT INTO tool (id, serial_number)
VALUES ('1', 12345),
       ('2', 54321);

INSERT INTO material (id, name, type, quantity_in_stock)
VALUES ('1', 'Wood', 'Building Material', 100),
       ('2', 'Concrete', 'Building Material', 200);