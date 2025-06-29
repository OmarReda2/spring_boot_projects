

# 1- E-Commerce Management System

The **E-Commerce Management System (ECMS)** is a modern, scalable platform designed to streamline product and category management in online stores. Built with **Java**, **Spring Boot**, and **MySQL**, it offers a robust backend API that serves both administrators and users through intuitive endpoints, ensuring efficient management and seamless integration.

---

## Key Features

### 🧩 Common Features
  * RESTful API for integration with frontend platforms <br />
  * Centralized Exception Handling using `@ControllerAdvice` <br />
  * Consistent API responses with a custom response handler <br />
  * Pagination and search support

### 🔐 Admin Features
   * Add, Edit, List, and Delete Products <br />
   * Add, Edit, List, and Delete Categories <br />
   * View paginated product/category lists

### 👤 User Features
   * Browse products by category or search <br />
   * View product details <br />
   * Paginate product lists for improved performance



## Project Structure

```bash
ecommerce-management-system/
├── src/
│   ├── main/
│   │   ├── java/com/myapp/ecommerce/
│   │   │   ├── dao/               # Data Access Objects
│   │   │   ├── dto/               # DTOs and mappers
│   │   │   ├── entity/            # JPA entities
│   │   │   ├── handler/           # Exception & response handling
│   │   │   ├── rest/              # REST controllers
│   │   │   ├── service/           # Business logic
│   │   │   └── EcommerceApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── schema.sql
│   └── test/                     # Unit & integration tests
├── pom.xml                       # Maven configuration
└── .gitignore                    # Git ignore file
````

---

## Prerequisites

Make sure you have the following installed:

* Java 17+
* Maven 3.8+
* MySQL 8+
* Git

---

## How to Run the Project

### 🔧 Backend (Spring Boot)

```bash
# Clone the repository
git clone https://github.com/your-username/ecommerce-management-system.git
cd ecommerce-management-system

# Create the database
mysql -u root -p
CREATE DATABASE ecommerce_db;

# Configure your credentials in application.properties
# Then build and run the project
mvn clean install
mvn spring-boot:run
```

The backend server will be available at:
**[http://localhost:8080/](http://localhost:8080/)**

---



## Technologies Used

* **Backend**: Java, Spring Boot, Spring Data JPA
* **Database**: MySQL
* **Build Tool**: Maven
* **Mapping**: MapStruct
* **Exception Handling**: Spring ControllerAdvice

---

  
  

  
  
  


# 2- Resume Builder Application

The **Resume Builder Application** is a scalable platform designed to manage user profiles, education, courses, and links for building professional resumes. Built with **Java**, **Spring Boot**, and **MySQL**, it provides a robust backend API for seamless integration with frontend platforms, ensuring efficient data management and user interaction.

---

## Key Features

### 🧩 Common Features
  * RESTful API for integration with frontend platforms <br />
  * Centralized Exception Handling using `@ControllerAdvice` <br />
  * Consistent API responses with a custom response handler <br />
  * Pagination and search support

### 🔐 Admin Features
   * Add, Edit, List, and Delete User Profiles <br />
   * Manage Education, Courses, and Links for users <br />
   * View paginated lists of user-related data

### 👤 User Features
   * Add and update personal information <br />
   * Manage education, courses, and links <br />
   * View and retrieve resume-related data

---

## Project Structure

```bash
resume-builder-application/
├── src/
│   ├── main/
│   │   ├── java/com/myapp/cResume/
│   │   │   ├── config/             # Configuration files
│   │   │   ├── controller/         # REST controllers
│   │   │   ├── dao/                # Data Access Objects
│   │   │   ├── entity/             # JPA entities
│   │   │   ├── service/            # Business logic
│   │   │   ├── service/interfaces/ # Service interfaces
│   │   │   └── CResumeApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── schema.sql
│   └── test/                       # Unit & integration tests
├── pom.xml                         # Maven configuration
└── .gitignore                      # Git ignore file
```

---

## Prerequisites

Make sure you have the following installed:

* Java 17+
* Maven 3.8+
* MySQL 8+
* Git

---

## How to Run the Project

### 🔧 Backend (Spring Boot)

```bash
# Clone the repository
git clone https://github.com/your-username/resume-builder-application.git
cd resume-builder-application

# Create the database
mysql -u root -p
CREATE DATABASE resume_app;

# Configure your credentials in application.properties
# Then build and run the project
mvn clean install
mvn spring-boot:run
```

The backend server will be available at:
**[http://localhost:8080/](http://localhost:8080/)**




---

## Technologies Used

* **Backend**: Java, Spring Boot, Spring Data JPA
* **Database**: MySQL
* **Build Tool**: Maven
* **Mapping**: Custom Entity Mapping
* **Exception Handling**: Spring ControllerAdvice

---
