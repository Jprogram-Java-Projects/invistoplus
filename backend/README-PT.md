# Invisto+ Backend (API REST Spring Boot)

API REST profissional desenvolvida com **Spring Boot 3.4** para gerenciamento de carteiras de investimentos.

---

## 🎯 Recursos

- ✅ Gestão de ativos: Ações, Fundos, Títulos Públicos
- ✅ Operações de compra/venda com cálculos automatizados de rendimentos
- ✅ Persistência em banco de dados relacional
- ✅ Documentação API Swagger interativa
- ✅ Separação de camadas em arquitetura orientada a domínio (Clean Architecture)

---

## 🚀 Como Executar

```bash
cd backend
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

A API ficará em `http://localhost:8080` e Swagger UI em `http://localhost:8080/swagger-ui.html`.

---

## 🧪 Testes

```bash
cd backend
./mvnw test
```

Os testes usam banco H2 em memória - não requer Docker para desenvolvimento.

---

## 🔌 Endpoints da API

| Endpoint | Método | Descrição |
|----------|--------|-------------|
| `/api/v1/investments` | GET | Listar todos os investimentos |
| `/api/v1/investments/{id}` | GET | Buscar investimento por ID |
| `/api/v1/investments/stocks` | POST | Criar uma ação |
| `/api/v1/investments/funds` | POST | Criar fundo de investimento |
| `/api/v1/investments/bonds` | POST | Criar título público |
| `/api/v1/investments/total-yield` | GET | Calcular rendimento total |
| `/api/v1/investments/{id}` | DELETE | Remover investimento |

---

## 🛠️ Pilha Tecnológica

| Camada | Tecnologia |
|--------|------------|
| **Linguagem** | Java 21 |
| **Framework** | Spring Boot 3.4 |
| **Persistência** | Spring Data JPA |
| **Banco** | PostgreSQL (prod), H2 (dev) |
| **Migrations** | Flyway |
| **API Docs** | OpenAPI 3/Swagger UI |
| **Testes** | JUnit 5, Mockito |
| **Build** | Maven |

---

## 📖 Recursos Adicionais

- **[Roadmap Detalhado](../ROADMAP.md)** — Plano de evolução
- **[English README.md](../README.md)** — English version
- **[Console README.md](../console/README.md)** — Documentação do console

---

*Desenvolvido por Jefferson Gomes para estudo e portfólio técnico.*
