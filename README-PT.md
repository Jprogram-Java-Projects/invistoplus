# Invisto+ - Carteira de Investimentos

🎓 **Projeto Fullstack completo demonstrando evolução de Java 21 POO até Spring Boot 3.4**

---

## 📌 Visão Geral

O **Invisto+** é um projeto educacional e demonstração técnica que evoluiu de um simples sistema de console em Java para uma API REST corporativa. É perfeito para mostrar desde fundamentos de POO até arquitetura de sistemas profissionais.

### 🎯 O que o projeto demonstra:

| Competência | Localização |
|-------------|-------------|
| Programação Orientada a Objetos (POO) | `console/` |
| Interfaces, Abstract Classes, Generics, Inheritance | `console/` |
| Spring Boot 3.4, Java 21 | `backend/` |
| REST API com OpenAPI/Swagger | `backend/` |
| PostgreSQL + Flyway Migrations | `backend/` |
| Testes com JUnit 5 + Mockito | `backend/` |
| Arquitetura em camadas (Clean Architecture) | `backend/` |

---

## 📁 Estrutura do Repositório

```
invistoplus/
├── console/                # Versão POO em Console (Java 21)
│   └── Trabalha orientação a objetos, generics, herança
│
├── backend/                # API Spring Boot 3.4 REST
│   └── Arquitetura profissional de backend
│
├── ROADMAP.md              # Plano de evolução documentado
└── README.md               # Este arquivo (em inglês)
```

---

## ▶️ Como Executar

### Console (POO Puro - Java 21)

```bash
cd console
javac src/**/*.java
java src/br/com/invistoplus/Main.java
```

### Backend (Spring Boot - API REST)

```bash
cd backend
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

A API ficará em `http://localhost:8080` e Swagger UI em `http://localhost:8080/swagger-ui.html`.

---

## 🧪 Testes

```bash
# Testes com H2 (sem Docker)
cd backend
./mvnw test

# Verificar relatório
open target/surefire-reports/*.txt
```

---

## 📌 Roadmap & Evolução

Consulte [ROADMAP.md](./ROADMAP.md) para detalhes completos.

| Fase | Status | Descrição |
|------|--------|-------------|
| 1 | ✅ Concluído | POO em Console (Java 21) |
| 2 | ✅ Concluído | REST API Spring Boot 3.4 |
| 3 | 🔄 Em progresso | Testes automatizados |
| 4 | ✅ Planejado | Frontend Vue.js/React |
| 5 | ✅ Planejado | Docker + CI/CD |

---

## 🧑‍💻 Sobre o Projeto

**Invisto+** é um sistema de simulação de carteira de investimentos que permite:

- ✅ Gestão de ativos: Ações, Fundos de Investimento, Títulos Públicos
- ✅ Operações de compra/venda com cálculo de rendimentos
- ✅ Persistência em banco de dados relacional
- ✅ Documentação API interativa via Swagger
- ✅ Arquitetura orientada a domínio

---

## 🚀 Tecnologias

| Camada | Console | Backend |
|--------|---------|---------|
| **Linguagem** | Java 21 | Java 21 |
| **Framework** | - | Spring Boot 3.4 |
| **Persistência** | - | Spring Data JPA |
| **Banco** | - | PostgreSQL (prod), H2 (dev) |
| **Migrations** | - | Flyway |
| **API Docs** | - | OpenAPI 3/Swagger UI |
| **Testes** | - | JUnit 5, Mockito |
| **Build** | javac | Maven |

---

## 📦 Tags

Use as tags do Git para ver versões específicas:

| Tag | Descrição |
|-----|-------------|
| `v0.0.1` | Versão inicial do console (POO puro) |
| `main` | Versão atual com console + backend |

---

## 📖 Recursos Adicionais

- **[Roadmap Detalhado](./ROADMAP.md)** — Plano completo de evolução
- **[Backend README](./backend/README.md)** — Documentação da API
- **[Console README](./console/README.md)** — Documentação do projeto original
- **[Read in English](./README.md)** — English version

---

## 🤝 Contribuições

Se quiser contribuir, fique à vontade! Abra um **Issue** ou envie um **Pull Request**.

---

## 📄 Licença

Este projeto está sob licença MIT - sinta-se livre para usar, modificar e distribuir.

---

*Desenvolvido por Jefferson Gomes para estudo e portfólio técnico.*