# shopping-parent

This is the **parent project** for the Shopping Cart System built with **Java 17** and **Spring Boot 3.4.3**.

It provides centralized configuration for dependency and plugin management across all microservices in the system.

## ✅ Purpose

- Define consistent dependency versions
- Share build configuration across all modules
- Simplify maintenance and promote clean project structure

## 📦 Modules managed by this parent:

- `common-entities`: Shared DTOs and entity definitions
- `shopping-auth`: Authentication and JWT handling
- `product-service`: Proxy for external product API
- `order-service`: Order management logic
- `payment-service`: Simulated payment processing

## 🛠 Tech Stack

- Java 17 (LTS)
- Spring Boot 3.4.3
- Maven 3.8+
- UTF-8 encoding

## 🔧 Features

- Inherits Spring Boot BOM for dependency consistency
- Compiler plugin configured for Java 17
- Spring Boot Maven plugin enabled
- Ready to be imported into any IDE (IntelliJ, VS Code)

## 📁 Usage

When cloning the full project:

```bash
mvn clean install
