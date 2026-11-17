# Invisto+ Console (POO Puro)

Versão original do projeto desenvolvida para treinar **conceitos avançados de Programação Orientada a Objetos em Java 21**.

---

## 🎯 Objetivos do Projeto

* Aplicar **Interface** e **Polimorfismo**
* Criar uma **classe abstrata** base para tipos de investimentos
* Utilizar **Generics** para garantir segurança de tipos
* Implementar **herança** para especializar investimentos
* Estimular boas práticas com responsabilidade de classes e coesão

---

## 🧩 Estrutura do Sistema

### 🔹 Interface `Investment`

Métodos essenciais:

* `calculateYield()` — cálculo do rendimento
* `getName()` — identificação do ativo

### 🔹 Classe Abstrata `TypesInvestments<T>`

Define comportamento padrão e contratos genéricos para:

* `getName()` — herança
* `addInvestment()` — gerenciamento interno
* `listInvestments()` — exibição
* `totalYield()` — cálculo consolidado via Stream API

### 🔹 Classes Concretas

* `Stock` 🏛️ — renda variável
* `InvestmentFund` 📊 — fundos diversificados
* `PublicBond` 🏦 — renda fixa

---

## 🚀 Como Executar

```bash
javac src/**/*.java
java src/br/com/invistoplus/Main.java
```

---

## 📌 Versão

* Tag Git: `v0.0.1`
* Java 21
* POO pura - sem frameworks
