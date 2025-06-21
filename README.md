# E-Commerce Management System
The E-Commerce Management System is a robust platform designed to manage products, categories, and customer interactions efficiently. Built using Java and Spring Boot, this system provides a scalable and maintainable solution for e-commerce businesses.

---

## Key Features

### Common Features
✨ RESTful API for seamless integration <br />
✨ Consistent response handling with custom response handlers <br />
✨ Centralized exception handling for improved error management

### Admin Features
✨ Manage products and categories <br />
✨ View product and category details with pagination support

### User Features
✨ Search products by name <br />
✨ View product details <br />
✨ Browse products with pagination

---

## Project Structure
ecommerce-management-system/ ├── src/ │ ├── main/ │ │ ├── java/com/myapp/ecommerce/ │ │ │ ├── dao/ # Data Access Object layer │ │ │ ├── dto/ # Data Transfer Objects and mappers │ │ │ ├── entity/ # JPA entities │ │ │ ├── handler/ # Exception and response handling │ │ │ ├── rest/ # REST controllers │ │ │ ├── service/ # Business logic layer │ │ │ └── EcommerceApplication.java # Main application entry point │ │ └── resources/ │ │ ├── application.properties # Configuration files │ │ └── schema.sql # Database schema │ └── test/ # Unit and integration tests │ ├── pom.xml # Maven dependencies and build configuration └── .gitignore # Git ignore file

The backend server will be running at http://localhost:8080/.  <hr></hr>
API Endpoints
Product Endpoints
GET /api/products - Retrieve all products
GET /api/products/{id} - Retrieve product by ID
GET /api/products/search/findByNameContaining?name={name} - Search products by name
GET /api/products/paginate?id={id}&size={size}&page={page} - Paginate products
Category Endpoints
GET /api/categories - Retrieve all categories
GET /api/categories/{id} - Retrieve category by ID
<hr></hr>
Technologies Used
Backend: Java, Spring Boot, JPA, Hibernate
Database: MySQL
Build Tool: Maven
Mapping: MapStruct
Exception Handling: Spring Controller Advice
<hr></hr>

Contributors
Omar Reda - Developer
