# Invisto+ 📈💼

Invisto+ é um projeto desenvolvido para treinar conceitos avançados de programação orientada a objetos em Java, explorando **interfaces**, **classes abstratas**, **generics** e **herança**.

O sistema simula uma carteira de investimentos, permitindo operações como **comprar**, **vender**, **resgatar** e **calcular rendimento** de diferentes tipos de ativos financeiros.

---

## ✅ Objetivos do Projeto

* Aplicar **Interface** e **Polimorfismo**
* Criar uma **classe abstrata** base para tipos de investimentos
* Utilizar **Generics** para garantir segurança de tipos
* Implementar **herança** para especializar investimentos
* Estimular boas práticas com responsabilidade de classes e coesão

---

## 🧩 Estrutura do Sistema

### 🔹 Interface `Investimento`

Métodos essenciais:

* `comprar()`
* `vender()`
* `resgatar()`
* `calcularRendimento()`

### 🔹 Classe Abstrata `TiposInvestimentos<T>`

Define comportamento padrão e contratos genéricos para:

* `comprar()`
* `vender()`
* `calcularRendimento()`

Métodos mais específicos para subclasses:

* `resgatar()`
* `listarRendimento()`

### 🔹 Classes Concretas

Cada uma representa um investimento real:

* `Acao` 🏛️ — renda variável
* `FundoInvestimento` 📊 — fundos diversificados
* `TituloPublico` 🏦 — renda fixa

---

## 🚀 Funcionalidades

* Cadastro de investimentos
* Operações de compra/venda
* Resgates específicos por tipo de ativo
* Cálculo de rendimento individual
* Demonstração do funcionamento no console

---

## 🛠️ Tecnologias Utilizadas

* **Java 21** ☕
* Paradigma **POO**
* **Collections** e **Generics**
* Boas práticas de design

---

## ▶️ Como Executar

```bash
# Clonar o repositório
git clone https://github.com/usuario/invistoplus.git
cd invistoplus

# Compilar e executar o projeto
javac src/**/*.java
java src/Main.java
```

---

## 📌 Próximas Melhorias

* Persistência de dados com arquivos ou banco
* Interface gráfica (JavaFX ou Web)
* Relatórios de desempenho da carteira
* Testes unitários com JUnit

---

## 🧑‍💻 Autor

Projeto desenvolvido para estudo e aprimoramento de conceitos de POO em Java.

Se quiser contribuir, fique à vontade! Pull requests são bem-vindos 🚀✨
