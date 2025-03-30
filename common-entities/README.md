# common-entities

This module contains shared JPA entities and DTOs used across the shopping-cart microservices.

## 📦 Purpose

The goal of this module is to centralize core domain models related to user authentication and management, in order to:

- Avoid duplication across services
- Maintain consistency in data structure
- Improve maintainability and reusability

## 🔧 Included Components

### Entities
- `User`: Core representation of a system user
- `Role`: Represents system roles (e.g. ADMIN, CUSTOMER)
- `AuthUserRole`: Many-to-many relationship between users and roles
- `UserStatus`: Enumeration of user status (Active, Suspended, etc.)
- `Auditable`: Base class for audit fields (createdAt, updatedAt)

### DTOs
- `RegisterRequest`
- `LoginRequest`
- `AuthResponse`

## 💡 Usage

This module is imported as a dependency into other microservices such as:

- `shopping-auth`: for login and registration
- `order-service`, `payment-service`: for user validation and auditing

## 🚀 Technologies

- Java 17
- Spring Boot 3.4
- JPA (Jakarta)
- Lombok

---
