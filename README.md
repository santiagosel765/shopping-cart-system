# 🛒 Shopping Cart Microservices System

This project implements a **microservices-based shopping cart system** using **Spring Boot 3.4**, **Java 17**, and **PostgreSQL**. Each module encapsulates a single responsibility following **SOLID**, **RESTful**, and **domain-driven** design principles.

---

## 📦 Modules Overview

```
shopping-cart-system
├── shopping-parent         # Centralized dependency and plugin management (Maven parent POM)
├── common-entities         # Shared entities and DTOs across microservices
├── shopping-auth           # JWT-based authentication and authorization service
├── product-service         # Proxy to fakestoreapi.com to handle product information
├── order-service           # Handles order creation and retrieval
├── payment-service         # Simulates payment processing and tracks payment status
├── postman-collection      # Collection of Postman requests for all endpoints
└── README.md               # Project documentation
```

---

## ⚙️ Tech Stack

- **Java 17**
- **Spring Boot 3.4**
- **Spring Data JPA**
- **Spring Security (JWT)**
- **PostgreSQL**
- **Maven**
- **Lombok**
- **RestTemplate**
- **SOLID principles**
- **Clean Architecture**
- **Layered Service/Controller/DTO patterns**

---

## 🧱 Architecture

- ✅ Each microservice runs independently on its own port
- ✅ DTOs and entities are reused via `common-entities` module
- ✅ JWT-based authentication protects all endpoints
- ✅ Modularized Maven setup with parent POM
- ✅ Simulated external API integration (`fakestoreapi.com`)
- ✅ Payment logic is simulated and extensible for future real integrations

---

## 🔐 Authentication (JWT)

- Endpoints (except `/actuator/health`) require a **valid JWT token**
- Obtain a token via:
  ```http
  POST /shopping-auth/v1/auth/login
  {
    "username": "your_username",
    "password": "your_password"
  }
  ```

- Use the token in the header:
  ```
  Authorization: Bearer <your_token>
  ```

---

## 🚀 Microservice Endpoints

### 🔐 Auth Service (`http://localhost:8081/shopping-auth`)

| Method | Endpoint                  | Description             |
|--------|---------------------------|-------------------------|
| POST   | `/v1/auth/register`       | Register new user       |
| POST   | `/v1/auth/login`          | Authenticate user       |
| POST   | `/v1/auth/change-password`| Change or recover password |

---

### 🛍 Product Service (`http://localhost:8082/product-service`)

| Method | Endpoint                          | Description              |
|--------|-----------------------------------|--------------------------|
| GET    | `/v1/products`                    | Get all products         |
| GET    | `/v1/products/{id}`               | Get product by ID        |
| GET    | `/v1/products/category/{name}`    | Get products by category |
| POST   | `/v1/products`                    | Add fake product         |
| PUT    | `/v1/products/{id}`               | Update fake product      |
| DELETE | `/v1/products/{id}`               | Delete fake product      |

---

### 📦 Order Service (`http://localhost:8083/order-service`)

| Method | Endpoint              | Description         |
|--------|-----------------------|---------------------|
| POST   | `/v1/orders`          | Create order        |
| GET    | `/v1/orders/{id}`     | Get order by ID     |
| GET    | `/v1/orders`          | List all orders     |

---

### 💳 Payment Service (`http://localhost:8084/payment-service`)

| Method | Endpoint                   | Description                  |
|--------|----------------------------|------------------------------|
| POST   | `/v1/payments/process`     | Simulate payment processing  |
| GET    | `/v1/payments/status/{id}` | Get payment status by Order ID |

---

## 🧪 Postman Collection

✅ Import the complete Postman collection:

[🟢 shopping-cart-full-collection.json](postman-collection/shopping-cart-full-collection.json)

Use the **login endpoint** to get a token, and test all services with the same base database (`shopping-cart-db`).

---

## 🛠 Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-user/shopping-cart-system.git
   cd shopping-cart-system
   ```

2. **Start PostgreSQL locally**:
   - Create a DB: `shopping-cart-db`
   - Default user: `postgres` / `root`

3. **Run microservices individually** from their module:
   ```bash
   mvn spring-boot:run
   ```

4. **Import Postman collection** to test all endpoints.

---

## 📌 Best Practices Followed

- ✅ Clean code with package-by-feature structure
- ✅ DTO separation from entity logic
- ✅ Robust JWT security
- ✅ Reusability through shared module (`common-entities`)
- ✅ RESTful endpoint design
- ✅ Layered architecture with services, repositories, and controllers
- ✅ Exception handling and HTTP status codes
- ✅ Git branching, commit hygiene, and PR structure

---

## 📬 Author

Developed as part of a backend technical assessment using industry best practices.


Selvin Santiago Pu Chiguil 

selvin.san90@gmail.com
