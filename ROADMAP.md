# 🗺️ Roadmap de Evolução — Invisto+

Este documento detalha o plano de ação passo a passo para evoluir o **Invisto+** de um projeto educacional de POO em Java 21 para uma **aplicação Fullstack de nível corporativo (Production-Ready)**.

---

## 📌 Status Geral do Projeto

- [x] **Fase 0: Core Domain & POO Console (Concluído)**
  - Abstração de investimentos via interface `Investment`.
  - Abstração genérica com `TypesInvestments<T extends Investment>`.
  - Implementação de `Stock`, `InvestmentFund` e `PublicBond`.
  - Gerenciamento de carteira com `Portfolio<T>`.
  - Interface CLI em console (`Menu.java` / `Main.java`).

- [x] **Fase 1: Core Backend & Banco de Dados (Spring Boot + PostgreSQL)**
  - ✅ Migrado para **Spring Boot 3.4** (Java 21)
  - ✅ **BigDecimal** para precisão financeira
  - ✅ Persistência com **PostgreSQL** + **Flyway migrations**
  - ✅ Desenvolvimento sem Docker (H2 para testes)

- [x] **Fase 2: REST API & Documentação OpenAPI / Swagger**
  - ✅ Endpoints RESTful criados (`GET`, `POST`, `DELETE`)
  - ✅ Documentação com **Swagger UI** em `/swagger-ui.html`
  - ✅ Tratamento de exceções via `@ControllerAdvice`

- [ ] **Fase 3: Suíte de Testes Automatizados (JUnit 5 + Mockito + Testcontainers)**
  - [ ] Testes de integração com Testcontainers (requer Docker)
  - ✅ Testes unitários funcionais com H2 em memória

### 🎯 Fase 1: Core Backend & Banco de Dados (Spring Boot + PostgreSQL)
- [ ] **Migração para Spring Boot 3.x (Java 21)**
  - Reestruturar o projeto com Maven/Gradle e pacotes padrão Spring (`controller`, `service`, `repository`, `domain`, `dto`, `exception`).
- [ ] **Modelagem Financeira de Precisão (`BigDecimal`)**
  - Substituir todos os tipos `double` monetários e de taxas por `java.math.BigDecimal` com arredondamento `RoundingMode.HALF_EVEN`.
- [ ] **Persistência Relacional com PostgreSQL**
  - Mapear entidades JPA (`@Entity`, `@Table`, `@Id`, `@Column`).
  - Configurar `application.yml` para banco PostgreSQL (produção/dev) e H2 (testes rápidos).
- [ ] **Versionamento de Banco com Flyway**
  - Criar migrations SQL (`V1__create_tables.sql`) para controle de schema.

---

### 🌐 Fase 2: REST API & Documentação OpenAPI / Swagger
- [ ] **Arquitetura de Endpoints RESTful**
  - `GET /api/v1/portfolio` — Listar carteira e resumo consolidado.
  - `POST /api/v1/investments/buy` — Registrar compra de ativo.
  - `POST /api/v1/investments/sell` — Registrar venda de ativo.
  - `GET /api/v1/investments/yield` — Consultar rendimentos detalhados.
- [ ] **Tratamento de Exceções de Domínio**
  - Criar `@ControllerAdvice` global com exceções customizadas (`InvestmentNotFoundException`, `InsufficientBalanceException`).
- [ ] **Documentação Interativa com Swagger UI**
  - Configurar `springdoc-openapi` para documentar endpoints, esquemas DTO e códigos de resposta HTTP.

---

### 🧪 Fase 3: Suíte de Testes Automatizados (JUnit 5 + Mockito + Testcontainers)
- [ ] **Testes Unitários (JUnit 5 + Mockito)**
  - Cobertura de 100% das regras de cálculo de rendimento (`Stock`, `InvestmentFund`, `PublicBond`).
  - Testes unitários para serviços de carteira e validações financeiras.
- [ ] **Testes de Integração (Testcontainers + PostgreSQL)**
  - Subir container Docker real do PostgreSQL nos testes de integração para validar queries, transações JPA e migrations Flyway.

---

### 🎨 Fase 4: Frontend Moderno (Vue.js 3 / React)
- [ ] **Desenvolvimento do Dashboard Web**
  - Escolha da stack: **Vue 3 (Composition API + PrimeVue)** ou **React (Vite + Tailwind + Recharts)**.
- [ ] **Funcionalidades da Interface**
  - Visão geral da carteira com gráfico de pizza (alocação por tipo de ativo).
  - Tabela interativa de ativos na carteira com filtro e ordenação.
  - Formulários modais para novas compras e simulação de vendas.
  - Card de rendimento acumulado total atualizado em tempo real via REST API.

---

### 🐳 Fase 5: DevOps, Containerização & CI/CD GitHub
- [ ] **Orquestração com Docker Compose**
  - Criar `docker-compose.yml` para subir Backend (Spring Boot), Frontend (Nginx/Node) e Banco (PostgreSQL) com um único comando (`docker compose up`).
- [ ] **Pipeline de CI/CD com GitHub Actions**
  - Criar `.github/workflows/ci.yml` para compilar, rodar linter e executar a suíte de testes JUnit/Testcontainers em todo Push ou Pull Request.
- [ ] **Melhorias de Portfólio no GitHub**
  - Adicionar badges no README (Java 21, Spring Boot, PostgreSQL, Build Status).
  - Incluir diagramas arquiteturais em Mermaid.js no `README.md`.
