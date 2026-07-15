# Visitor Log API

## Project Description

Visitor Log API is a Spring Boot RESTful application that manages visitor records.  
The API allows users to create, retrieve, update, and delete visitor information.

The project demonstrates:
- Spring Boot REST API development
- JPA/Hibernate database integration
- CRUD operations
- Repository and Service layers
- RESTful endpoint design

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Maven
- Database (H2/MySQL depending on configuration)

---

## Project Structure

```
src/main/java
 └── com.example.visitorlog
      ├── controller   # REST API controllers
      ├── service      # Business logic
      ├── repository   # Database access layer
      └── model        # Entity classes
```

---

## API Endpoints

### Visitor APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/visitors` | Get all visitors |
| GET | `/api/visitors/{id}` | Get visitor by ID |
| POST | `/api/visitors` | Create a new visitor |
| PUT | `/api/visitors/{id}` | Update visitor information |
| DELETE | `/api/visitors/{id}` | Delete a visitor |



##Install docker in VM
![img.png](img.png)
###Create image and run the container
![img_1.png](img_1.png)