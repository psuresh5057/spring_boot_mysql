# Spring Boot MySQL Project

## Overview
This project is a Spring Boot application integrated with MySQL. It provides RESTful APIs for managing employees, departments, and job titles. The application also includes Swagger for API documentation.

## Features
- CRUD operations for Employees, Departments, and Job Titles.
- API documentation using Swagger.
- MySQL database integration.
- Validation for input data.

## Prerequisites
- Java 17 or higher
- MySQL database
- Gradle build tool

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository-url>
cd spring_boot_mysql
```

### 2. Configure the Database
Update the `application.properties` file located in `src/main/resources/` with your MySQL database credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build the Project
Run the following command to build the project:
```bash
./gradlew clean assemble build
```

### 4. Run the Application
Start the application using:
```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080` by default.

### 5. Access Swagger UI
Visit `http://localhost:8080/swagger-ui.html` to explore the API documentation.

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── spring/
│   │           ├── controller/    # REST controllers
│   │           ├── model/         # Entity classes
│   │           ├── repository/    # JPA repositories
│   │           └── service/       # Service layer
│   └── resources/
│       └── application.properties # Configuration file
└── test/
    └── java/
        └── com/
            └── spring/            # Test cases
```

## Testing
Run the test cases using:
```bash
./gradlew test
```
Test reports can be found in `build/reports/tests/test/index.html`.

## License
This project is licensed under the MIT License. See the LICENSE file for details.
