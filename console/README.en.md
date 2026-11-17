# Invisto+ Console (Pure OOP)

Invisto+ is designed to practice advanced Object-Oriented Programming concepts in Java 21, exploring **interfaces**, **abstract classes**, **generics**, and **inheritance**.

The system simulates an investment portfolio, allowing operations such as **buy**, **sell**, **withdraw**, and **calculate returns** for different types of financial assets.

---

## ✅ Project Objectives

* Apply **Interfaces** and **Polymorphism**
* Create an **abstract base class** for investment types
* Use **Generics** to ensure type safety
* Implement **inheritance** to specialize investments
* Encourage clean design, class responsibility, and cohesion

---

## 🧩 System Structure

### 🔹 Interface `Investment`

Essential methods:

* `calculateYield()` — yield calculation
* `getName()` — asset identification

### 🔹 Abstract Class `TypesInvestments<T>`

Defines default behavior and generic contracts for:

* `getName()` — inheritance
* `addInvestment()` — internal management
* `listInvestments()` — display
* `totalYield()` — consolidated calculation via Stream API

### 🔹 Concrete Classes

* `Stock` 🏛️ — variable income (equity)
* `InvestmentFund` 📊 — diversified funds
* `PublicBond` 🏦 — fixed income

---

## 🚀 How to Run

```bash
javac src/**/*.java
java src/br/com/invistoplus/Main.java
```

---

## 📌 Version

* Git Tag: `v0.0.1`
* Java 21
* Pure OOP - no frameworks

---

## 📖 Additional Resources

- **[English README.md](../README.md)** — Project overview in English
- **[Portuguese README.md](../README-PT.md)** — Versão em português
