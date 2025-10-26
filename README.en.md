\# Invisto+ 📈💼



🌎 Leia em \[Português](README.md)



Invisto+ is a project designed to practice advanced Object-Oriented Programming concepts in Java, exploring \*\*interfaces\*\*, \*\*abstract classes\*\*, \*\*generics\*\*, and \*\*inheritance\*\*.



The system simulates an investment portfolio, allowing operations such as \*\*buy\*\*, \*\*sell\*\*, \*\*withdraw\*\*, and \*\*calculate returns\*\* for different types of financial assets.



---



\## ✅ Project Objectives



\* Apply \*\*Interfaces\*\* and \*\*Polymorphism\*\*

\* Create an \*\*abstract base class\*\* for investment types

\* Use \*\*Generics\*\* to ensure type safety

\* Implement \*\*inheritance\*\* to specialize investments

\* Encourage clean design, class responsibility, and cohesion



---



\## 🧩 System Structure



\### 🔹 Interface `Investment`



Essential methods:



\* `buy()`

\* `sell()`

\* `withdraw()`

\* `calculateReturn()`



\### 🔹 Abstract Class `InvestmentTypes<T>`



Defines default behavior and generic contracts for:



\* `buy()`

\* `sell()`

\* `calculateReturn()`



More specific behaviors for subclasses:



\* `withdraw()`

\* `listReturn()`



\### 🔹 Concrete Classes



Each one represents a real investment type:



\* `Stock` 🏛️ — variable income asset

\* `InvestmentFund` 📊 — diversified funds

\* `GovernmentBond` 🏦 — fixed income asset



---



\## 🚀 Features



\* Investment registration

\* Buy/sell operations

\* Specific withdrawals by asset type

\* Return calculations per investment

\* Console output demonstrating functionality



---



\## 🛠️ Technologies Used



\* \*\*Java 21\*\* ☕

\* \*\*OOP paradigm\*\*

\* \*\*Collections\*\* and \*\*Generics\*\*

\* Design best practices



---



\## ▶️ How to Run



```bash

\# Clone repository

git clone https://github.com/Jprogram-Java-Projects/invistoplus.git

cd invistoplus



\# Compile and execute

javac src/\*\*/\*.java

java src/Main.java

```



---



\## 📌 Next Improvements



\* Data persistence using files or database

\* GUI (JavaFX or Web)

\* Portfolio performance reports

\* Unit testing with JUnit



---



\## 🧑‍💻 Author



Project developed for study and improvement of Java OOP concepts.



Feel free to contribute! Pull requests are welcome 🚀✨



