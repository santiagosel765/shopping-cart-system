# shopping-auth

Authentication microservice for the **Shopping Cart System**.  
Handles user registration, login, password recovery, and role-based authorization using JWT.

---

## 📌 Prerequisites

Before running this service, make sure the following modules are present and properly configured:

### 🔁 [common-entities](../common-entities)

> Shared entities and DTOs used across all microservices.

### 📦 [shopping-parent](../shopping-parent)

> Parent module that centralizes dependency and plugin versions using Java 17 and Spring Boot 3.4.

---

## 🎯 Features

- 🔐 **User Registration** with default role assignment (`USER`)
- 🔑 **Login Authentication** using **JWT**
- 🔁 **Password Recovery** and **Change Password** functionality
- 📜 Role-based access control via `AuthUserRole`
- 🗃️ Loads default **UserStatus** and **Role** values from `data.sql`
- 🧾 Secure endpoints with JWT-based Spring Security filter

---

## 📂 Project Structure

```
shopping-auth
├── config           # JWT config and filter setup
│   └── security     # JWT utilities and filters
├── controller       # REST API endpoints
├── repository       # Spring Data JPA interfaces
├── service          # Core business logic
│   └── impl         # Service implementations
├── resources
│   ├── application.yml  # DB + JWT configuration
│   └── data.sql         # Default roles and user statuses
```

---

## 🚀 Technologies Used

- Java 17
- Spring Boot 3.4.x
- Spring Security
- JWT (JJWT)
- PostgreSQL
- Lombok
- Maven

---

## 🛠️ Usage

### 🔧 Configuration

Edit `application.yml` with your local database credentials:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/shopping-cart-db
    username: postgres
    password: root
jwt:
  secret: your-super-secret-key
```

> Default roles and statuses will be auto-inserted using `data.sql`.

---

### ▶️ Running the Service

Make sure the following modules are built and installed first:

1. `common-entities`
2. `shopping-parent`

Then, run:

```bash
./mvnw spring-boot:run
```

---

## 📤 API Endpoints

| Endpoint                    | Method | Auth Required | Description                        |
|-----------------------------|--------|---------------|------------------------------------|
| `/auth/register`           | POST   | ❌            | Register a new user                |
| `/auth/login`              | POST   | ❌            | Authenticate and return JWT token |
| `/auth/change-password`    | POST   | ✅            | Update password (JWT required)     |

> Use JWT in `Authorization: Bearer <token>` for protected routes.

---

## 🔐 JWT Details

- Issued at login
- Contains: username, expiration
- Validated in a custom filter for protected endpoints

---

## 👨‍💻 Author

Developed and maintained by the Shopping Cart engineering team.  
Contact: [`selvin.san90@gmail.com`](mailto:dev-team@shopping.com)

---
