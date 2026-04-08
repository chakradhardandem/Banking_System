# 🏦 Secure Online Banking System

A full-stack web application that simulates core banking operations such as account management, fund transfer, and transaction tracking.

---

## 🚀 Tech Stack

### 🔹 Frontend

* HTML
* CSS
* JavaScript
* React (Vite)
* Axios
* React Router

### 🔹 Backend

* Java
* Spring Boot
* Spring Data JPA
* REST APIs

### 🔹 Database

* MySQL

---

## 🔥 Features

### 👤 User Features

* User Registration & Login
* Automatic Account Creation
* View Account Balance
* Deposit Money
* Withdraw Money
* Transfer Funds
* View Transaction History

### 🔐 Security

* Basic Authentication (can be extended to JWT)

### 📊 System Features

* RESTful API architecture
* Relational database design
* Transaction management using `@Transactional`

---

## 🧠 Architecture

React (Frontend)
⬇ REST API (Axios)
Spring Boot (Backend)
⬇
MySQL Database

---

## ⚙️ Setup Instructions

### 🔹 Backend (Spring Boot)

1. Clone the repository
2. Open in IntelliJ / Eclipse
3. Configure `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banking_app
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4. Run the application

---

### 🔹 Frontend (React - Vite)

```bash
cd banking-ui
npm install
npm run dev
```

---

## 📂 Project Structure

### Backend

```
com.tap
 ├── entity
 ├── repository
 ├── service
 ├── controller
```

### Frontend

```
src/
 ├── pages/
 ├── components/
 ├── services/
```

---

## 🔄 API Endpoints

| Method | Endpoint      | Description             |
| ------ | ------------- | ----------------------- |
| POST   | /register     | Register user           |
| POST   | /login        | Login user              |
| POST   | /deposit      | Deposit money           |
| POST   | /withdraw     | Withdraw money          |
| POST   | /transfer     | Transfer funds          |
| GET    | /transactions | Get transaction history |

---

## 💡 Key Highlights

* Implemented automatic account creation during registration
* Used `@Transactional` to ensure consistency during fund transfer
* Designed relational database with proper entity mapping
* Built responsive UI with React and routing

---

## 📌 Future Enhancements

* JWT Authentication
* Email Notifications
* Admin Dashboard
* Charts & Analytics
* Multi-account support

---

## 🧾 Resume Description

Developed a secure full-stack Online Banking System using React and Spring Boot, enabling users to perform transactions such as deposit, withdrawal, and fund transfer. Implemented REST APIs, relational database design, and ensured data consistency using transactional management.

---

## 👨‍💻 Author

Chakradhar

---

