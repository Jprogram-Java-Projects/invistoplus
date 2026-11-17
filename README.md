# Invisto+ - Investment Portfolio

🌍 **Read this in Portuguese → [README-PT.md](./README-PT.md)**

🎓 **Full-stack project demonstrating evolution from Java 21 OOP to Spring Boot 3.4**

---

## 📌 Overview

**Invisto+** is an educational and technical demonstration project that evolved from a simple Java console system to a professional REST API. It's perfect for showcasing everything from OOP fundamentals to professional system architecture.

### 🎯 What the project demonstrates:

| Skill | Location |
|-------|----------|
| Object-Oriented Programming (OOP) | `console/` |
| Interfaces, Abstract Classes, Generics, Inheritance | `console/` |
| Spring Boot 3.4, Java 21 | `backend/` |
| REST API with OpenAPI/Swagger | `backend/` |
| PostgreSQL + Flyway Migrations | `backend/` |
| Testing with JUnit 5 + Mockito | `backend/` |
| Layered Architecture (Clean Architecture) | `backend/` |

---

## 📁 Repository Structure

```
invistoplus/
├── console/                # OOP Console Version (Java 21)
│   └── Demonstrates OOP principles, generics, and inheritance
│
├── backend/                # Spring Boot 3.4 REST API
│   └── Professional backend architecture
│
├── ROADMAP.md              # Detailed evolution roadmap
└── README.md               # This file
```

---

## ▶️ How to Run

### Console (Pure OOP - Java 21)

```bash
cd console
javac src/**/*.java
java src/br/com/invistoplus/Main.java
```

### Backend (Spring Boot - REST API)

```bash
cd backend
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

The API will be available at `http://localhost:8080` and Swagger UI at `http://localhost:8080/swagger-ui.html`.

---

## 🧪 Testing

```bash
# Tests with H2 (no Docker required)
cd backend
./mvnw test

# View test reports
open target/surefire-reports/*.txt
```

---

## 📌 Roadmap & Evolution

See [ROADMAP.md](./ROADMAP.md) for complete details.

| Phase | Status | Description |
|-------|--------|-------------|
| 1 | ✅ Complete | OOP in Console (Java 21) |
| 2 | ✅ Complete | REST API Spring Boot 3.4 |
| 3 | 🔄 In Progress | Automated Testing |
| 4 | ✅ Planned | Vue.js/React Frontend |
| 5 | ✅ Planned | Docker + CI/CD |

---

## 🧑‍💻 About the Project

**Invisto+** simulates an investment portfolio management system that allows:

- ✅ Asset management: Stocks, Investment Funds, Government Bonds
- ✅ Buy/sell operations with return calculations
- ✅ Relational database persistence
- ✅ Interactive API documentation via Swagger
- ✅ Domain-oriented architecture

---

## 🚀 Technology Stack

| Layer | Console | Backend |
|-------|---------|---------|
| **Language** | Java 21 | Java 21 |
| **Framework** | - | Spring Boot 3.4 |
| **Persistence** | - | Spring Data JPA |
| **Database** | - | PostgreSQL (prod), H2 (dev) |
| **Migrations** | - | Flyway |
| **API Docs** | - | OpenAPI 3/Swagger UI |
| **Testing** | - | JUnit 5, Mockito |
| **Build** | javac | Maven |

---

## 📦 Tags

Use Git tags to view specific versions:

| Tag | Description |
|-----|-------------|
| `v0.0.1` | Initial console version (Pure OOP) |
| `main` | Current version with console + backend |

---

## 📖 Additional Resources

- **[Detailed Roadmap](./ROADMAP.md)** — Complete evolution plan
- **[Backend README (EN)](./backend/README.md)** — API documentation
- **[Backend README (PT)](./backend/README-PT.md)** — Documentação da API em português
- **[Console README](./console/README.md)** — Original project documentation
- **[Portuguese version](./README-PT.md)** — Versão em português

---

## 🤝 Contributions

Feel free to contribute! Open an **Issue** or submit a **Pull Request**.

---

## 📄 License

This project is licensed under MIT - feel free to use, modify, and distribute.

---

*Developed by Jefferson Gomes for study and technical portfolio.*