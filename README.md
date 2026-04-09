# 🏧 JAATM-BEA

**JAATM-BEA** (Java ATM – Backend API) is a backend API application for a **fictitious ATM system**.  
The project was designed and developed to practice and demonstrate **full software development life cycle (SDLC)** skills — from design and implementation to testing and documentation.

---

## 📌 Project Purpose

The goal of this project is to:
- Simulate core ATM backend operations
- Apply real-world backend architecture principles
- Practice building, testing, and documenting a RESTful API
- Demonstrate clean code, layered architecture, and best practices

This project is **educational** and **not intended for production use**.

---

## ⚙️ Features

- User authentication (PIN / account-based)
- Account balance inquiry
- Cash withdrawal
- Cash deposit
- Transaction history
- Error handling and validation
- RESTful API design

---

## 🧱 Architecture

- **Backend:** Java-based REST API
- **Architecture style:** Layered / Service-oriented (can evolve to microservices)
- **Data management:** In-memory / relational database (depending on configuration)
- **API communication:** HTTP + JSON

---

## 🛠️ Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Build Tool:** Maven / Gradle
- **Database:** H2 / PostgreSQL / MySQL (configurable)
- **Testing:** JUnit, Mockito
- **API Documentation:** Swagger / OpenAPI
- **Version Control:** Git & GitHub

---

## 📂 Project Structure

```text
src
├── controller    # REST API endpoints
├── service       # Business logic
├── repository    # Data access layer
├── model         # Domain models / entities
├── dto           # Data transfer objects
├── exception     # Custom exceptions & handlers
└── config        # Application configuration
```

## Documentation
https://ashwinwitbooi.github.io/jaamt-bea-docs/