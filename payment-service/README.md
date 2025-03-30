# 💳 Payment Service

This microservice simulates the **payment process** for the shopping cart system. It handles payment requests and returns a simulated payment status.

---

## 🔐 JWT Authentication

All endpoints (except `/actuator/health`) are **protected** with JWT.

- Add your token in Postman under **Authorization → Bearer Token**, or  
- Include it in the headers as:  
  `Authorization: Bearer <your_token>`

---

## 🚀 Endpoints

| Method | Endpoint                 | Description                        |
|--------|--------------------------|------------------------------------|
| POST   | `/v1/payments/process`   | Simulate a payment process         |
| GET    | `/v1/payments/status/{orderId}` | Get simulated payment status by order ID |

---

## 🧾 Sample Request - Process Payment

```json
POST /v1/payments/process
Authorization: Bearer <your_token>
Content-Type: application/json

{
  "orderId": 101,
  "amount": 250.00,
  "paymentMethod": "CREDIT_CARD"
}
```

---

## 📦 Technologies

- Java 17
- Spring Boot 3.4
- Spring Security (JWT)
- Maven

---

## 🧩 Dependencies

This service depends on:

- `shopping-parent` for centralized config
- `common-entities` for shared DTOs and Enums

---

## 🗂 Folder Structure

```
src/main/java/com/shopping/payment
├── config             # Security and app config
│   └── security       # JWT filter, utilities, chain
├── controller         # REST controller for payments
├── dto                # PaymentRequestDto and PaymentResponseDto
├── service            # Payment service interface and impl
├── entity             # Payment entity (persisted in DB)
├── enums              # PaymentStatus enum
└── PaymentServiceApplication.java
```

---

## 🧪 Postman Testing

Use the **Payment Service API** Postman collection to test all endpoints.  
Make sure to obtain a valid JWT token from the `shopping-auth` service.

---

## 📝 Note

This service simulates payment processing.  
No real transactions are performed.
