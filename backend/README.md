# Invisto+ Backend (Spring Boot REST API)

🌍 **Read this in Portuguese → [README-PT.md](README-PT.md)**

Professional REST API built with **Spring Boot 3.4** for managing investment portfolios.

---

## 🎯 Features

- ✅ Investment management: Stocks, Funds, Government Bonds
- ✅ Buy/sell operations with automated return calculations
- ✅ Relational database persistence
- ✅ Interactive Swagger API documentation
- ✅ Domain-oriented (Clean Architecture) layer separation

---

## 🚀 How to Run

```bash
cd backend
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

The API will be available at `http://localhost:8080` and Swagger UI at `http://localhost:8080/swagger-ui.html`.

---

## 🧪 Testing

```bash
cd backend
./mvnw test
```

Tests run with H2 in-memory database - no Docker required for development.

---

## 🔌 API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/v1/investments` | GET | List all investments |
| `/api/v1/investments/{id}` | GET | Get investment by ID |
| `/api/v1/investments/stocks` | POST | Create a stock |
| `/api/v1/investments/funds` | POST | Create investment fund |
| `/api/v1/investments/bonds` | POST | Create public bond |
| `/api/v1/investments/total-yield` | GET | Get total portfolio yield |
| `/api/v1/investments/{id}` | DELETE | Remove investment |

---

## 🛠️ Technology Stack

| Layer | Technology |
|-------|------------|
| **Language** | Java 21 |
| **Framework** | Spring Boot 3.4 |
| **Persistence** | Spring Data JPA |
| **Database** | PostgreSQL (prod), H2 (dev) |
| **Migrations** | Flyway |
| **API Docs** | OpenAPI 3/Swagger UI |
| **Testing** | JUnit 5, Mockito |
| **Build** | Maven |

---

## 📖 Additional Resources

- **[Detailed Roadmap](../ROADMAP.md)** — Evolution plan
- **[English README.md](../README.md)** — Project overview
- **[Portuguese README.md](../README-PT.md)** — Versão em português

---

*Developed by Jefferson Gomes for study and technical portfolio.*