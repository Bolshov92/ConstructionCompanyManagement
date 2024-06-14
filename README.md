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

Docker Image: 
You can also run this project using Docker:

bash
Copy code
docker pull bolshov92/construction_company_management-web-service
docker run -p 8080:8080 bolshov92/construction_company_management-web-service

## Database Tables Structure

### Role Table
- **role_id**: UUID (Primary Key)
- **role_name**: VARCHAR(255)

### User Info Table
- **id**: UUID (Primary Key)
- **user_name**: VARCHAR(255)
- **password**: VARCHAR(255)
- **phone_number**: VARCHAR(20)
- **user_id**: UUID (Foreign Key, References Users Table)

### Users Table
- **id**: UUID (Primary Key)
- **first_name**: VARCHAR(255)
- **last_name**: VARCHAR(255)
- **date_of_birth**: DATE
- **registration_date**: DATE
- **user_info_id**: UUID (Foreign Key, References User Info Table)
- **role_id**: UUID (Foreign Key, References Role Table)

### Authority Table
- **id**: UUID (Primary Key)
- **authority**: VARCHAR(255)
- **role_id**: UUID (Foreign Key, References Role Table)
- **user_id**: UUID (Foreign Key, References Users Table)

### Department Table
- **id**: UUID (Primary Key)
- **dep_name**: VARCHAR(255)

### Company Table
- **id**: UUID (Primary Key)
- **name**: VARCHAR(255)
- **turnover**: DOUBLE
- **expenses**: DOUBLE
- **profit**: DOUBLE

### Employee Table
- **id**: UUID (Primary Key)
- **first_name**: VARCHAR(255)
- **last_name**: VARCHAR(255)
- **contact_info**: VARCHAR(255)
- **age**: INT
- **hire_date**: DATE
- **end_date**: DATE
- **department_id**: UUID (Foreign Key, References Department Table)
- **role_id**: UUID (Foreign Key, References Role Table)

### Construction Project Table
- **id**: UUID (Primary Key)
- **project_name**: VARCHAR(255)
- **address**: VARCHAR(255)
- **description**: VARCHAR(255)
- **startDate**: DATE
- **endDate**: DATE
- **manager_id**: UUID (Foreign Key, References Employee Table)
- **company_id**: UUID (Foreign Key, References Company Table)

### Material Table
- **id**: UUID (Primary Key)
- **name**: VARCHAR(255)
- **type**: VARCHAR(255)
- **quantity_in_stock**: INT


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
- Git Repositories <https://github.com/Bolshov92>
