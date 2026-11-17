# Invisto+ Backend (Spring Boot REST API)

API REST profissional desenvolvida com **Spring Boot 3.4** para gerenciamento de carteira de investimentos.

---

## 🎯 Tecnologias

| Tecnologia | Versão |
|------------|--------|
| **Java** | 21 |
| **Spring Boot** | 3.4.0 |
| **Spring Data JPA** | Persistência ORM |
| **PostgreSQL** | Banco de dados |
| **Flyway** | Migrations |
| **OpenAPI/Swagger** | Documentação |
| **JUnit 5 + Mockito** | Testes unitários |
| **Testcontainers (opcional)** | Testes de integração**

---

## 🚀 Como Executar

### Desenvolvimento (sem Docker - H2)

```bash
cd backend
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

A API ficará em `http://localhost:8080` e Swagger UI em `http://localhost:8080/swagger-ui.html`.

### Produção (com PostgreSQL)

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

---

## 🔌 Endpoints API

| Endpoint | Método | Descrição |
|----------|--------|-------------|
| `/api/v1/investments` | GET | Listar todos os investimentos |
| `/api/v1/investments/{id}` | GET | Buscar por ID |
| `/api/v1/investments/stocks` | POST | Criar ação |
| `/api/v1/investments/funds` | POST | Criar fundo |
| `/api/v1/investments/bonds` | POST | Criar título público |
| `/api/v1/investments/total-yield` | GET | Rendimento total |
| `/api/v1/investments/{id}` | DELETE | Remover investimento |

---

## 🧪 Testes

```bash
# Testes com H2 (sem Docker)
./mvnw test

# Testes com Testcontainers (requer Docker)
./mvnw test -Dspring.profiles.active=testcontainers
```

---

## 📌 Status

* **Phase 1:** ✅ Implementado
* **Phase 2:** ✅ Endpoint REST criados
* **Phase 3:** 🔄 Testes em andamento