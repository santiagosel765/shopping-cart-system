# 🛍️ Product Service

This microservice acts as a **proxy** to the public [FakeStoreAPI](https://fakestoreapi.com), allowing secure access to product information for the shopping cart system.

---

## 🔐 JWT Authentication

All endpoints (except `/actuator/health`) require a valid **JWT token**.

- Add the token in Postman under **Authorization → Bearer Token**, or
- Include in header: `Authorization: Bearer <your_token>`

---

## 🚀 Endpoints

| Method | Endpoint                          | Description                              |
|--------|-----------------------------------|------------------------------------------|
| GET    | `/v1/products`                    | Get all products                         |
| GET    | `/v1/products/{id}`               | Get a product by ID                      |
| GET    | `/v1/products/category/{name}`    | Get products by category                 |
| POST   | `/v1/products`                    | Add a new product (fake)                 |
| PUT    | `/v1/products/{id}`               | Update an existing product (fake)        |
| DELETE | `/v1/products/{id}`               | Delete a product (fake)                  |

---

## ⚙️ Technologies

- Java 17
- Spring Boot 3.4
- Spring Security (JWT)
- RestTemplate
- Maven

---

## 🧩 Dependencies

This service depends on:

- `shopping-parent` for common configurations
- `common-entities` for shared DTOs/entities

---

## 📦 Folder Structure

```
src/main/java/com/shopping/product
├── config             # App and Security config
│   └── security       # JWT filter, util, security chain
├── controller         # REST controller for products
├── service            # Product service interface and impl
└── ProductServiceApplication.java
```

---

## 🧪 Postman Testing

You can test endpoints by importing the **Product Service API** collection and setting the `Authorization` header using a token from `shopping-auth`.

---

## 🌐 External API Reference

All calls are delegated to:

[https://fakestoreapi.com](https://fakestoreapi.com)
