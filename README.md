# Construction Company Management System

This repository contains the backend system for managing a construction company. It provides functionalities for managing users, departments, employees, and more.

## Features

- **User Management**: Create, update, delete users with different roles.
- **Department Management**: Manage departments within the company.
- **Employee Management**: Create, update, delete employee profiles.
- **Financial Tracking**: Track financial data of the company.
- **Swagger API Documentation**: Detailed API documentation provided using Swagger.

## Installation

To run this project locally, follow these steps:

1. Clone the repository: `git clone https://github.com/Bolshov92/construction-company-management.git`
2. Navigate into the project directory: `cd construction-company-management`
3. Set up the database connection in the `src/main/resources/application.yml` file:

   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/construction_company_db?useSSL=false&serverTimezone=UTC
       username: your_database_username
       password: your_database_password
       driver-class-name: com.mysql.cj.jdbc.Driver
Replace localhost:3306 with the address of your database server and construction_company_db with the name of your database.
Replace your_database_username with your database username.
Replace your_database_password with your database password.

Build the project: ./mvnw clean install

## Usage

### Access Restrictions

Access to various endpoints is restricted based on user roles. You can manage roles easily to grant or restrict access as needed.

- **User Endpoints**:
    - `DELETE /user/delete/{id}`: Available for users with roles `ROLE_ADMIN`, `ROLE_SUPERVISOR`, and `ROLE_DIRECTOR`.
    - `PUT /user/update/{id}`: Available for users with roles `ROLE_ADMIN` and `ROLE_DIRECTOR`.
    - All other user endpoints are accessible to authenticated users.

- **Department Endpoints**:
    - `POST /department/create`: Available for users with roles `ROLE_ADMIN` and `ROLE_DIRECTOR`.
    - `DELETE /department/delete/{id}`: Available for users with roles `ROLE_ADMIN` and `ROLE_DIRECTOR`.
    - `PUT /department/update/{id}`: Available for users with roles `ROLE_ADMIN` and `ROLE_DIRECTOR`.
    - All other department endpoints are accessible to authenticated users.

- **Employee Endpoints**:
    - `DELETE /employee/delete/{id}`: Available for users with roles `ROLE_ADMIN` and `ROLE_DIRECTOR`.
    - `PUT /employee/update/{id}`: Available for users with roles `ROLE_ADMIN`, `ROLE_SUPERVISOR`, and `ROLE_DIRECTOR`.
    - `POST /employee/create`: Available for users with roles `ROLE_ADMIN`, `ROLE_SUPERVISOR`, and `ROLE_DIRECTOR`.
    - All other employee endpoints are accessible to authenticated users.

### Authentication

When the application starts, you need to authenticate with the username "admin" and the password "123123". After authentication as the admin user, you will have full access to all functionalities. Additionally, with this authentication, you can create, update, delete, and grant access rights to new users.

### Testing

This project includes integration tests for controllers and services. You can run them using the following command:

### Swagger Documentation

The API endpoints are documented using Swagger. You can access the documentation by running the application locally and visiting the following URL: `http://localhost:8080/swagger-ui/index.html`.

## Contributors

- Viacheslav Bolshov <bolshov92@gmail.com>
