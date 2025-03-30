# 📦 Order Service

This microservice manages **shopping orders**, including order creation, retrieval by ID, and listing all orders. It stores orders and their associated order items in a PostgreSQL database.

---

## 🔐 JWT Authentication

All endpoints (except `/actuator/health`) are **protected** with JWT.

- Add your token in Postman under **Authorization → Bearer Token**, or  
- Include it in the headers as:  
  `Authorization: Bearer <your_token>`

---

## 🚀 Endpoints

| Method | Endpoint             | Description               |
|--------|----------------------|---------------------------|
| POST   | `/v1/orders`         | Create a new order        |
| GET    | `/v1/orders/{id}`    | Get order by ID           |
| GET    | `/v1/orders`         | Get all orders            |

---

## 🧾 Sample Request - Create Order

```json
POST /v1/orders
Authorization: Bearer <your_token>
Content-Type: application/json

{
  "userId": 1,
  "items": [
    {
      "productId": 1,
      "quantity": 2,
      "price": 109.95
    },
    {
      "productId": 5,
      "quantity": 1,
      "price": 695.00
    }
  ]
}
```

---

## 📦 Technologies

- Java 17
- Spring Boot 3.4
- Spring Data JPA
- Spring Security (JWT)
- PostgreSQL
- Maven

---

## 🧩 Dependencies

This service depends on:

- `shopping-parent` for centralized config
- `common-entities` for shared entities and DTOs

---

## 🗂 Folder Structure

```
src/main/java/com/shopping/order
├── config             # Security and app config
│   └── security       # JWT filter, utilities, chain
├── controller         # REST controller for orders
├── entity             # JPA entities (from common-entities)
├── repository         # JPA Repositories
├── service            # Order service interface & impl
└── OrderServiceApplication.java
```

---

## 🧪 Postman Testing

Use the **Order Service API** Postman collection to test all endpoints.  
Make sure to obtain a valid JWT token from the `shopping-auth` service.

---

## 📝 Note

This service only implements **order management**.  
Clients and Products are assumed to be managed by their respective microservices.