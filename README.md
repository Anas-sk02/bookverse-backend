<div align="center">

# 📚 BookVerse API

### A Secure and Scalable Book Management REST API built with Spring Boot

Manage Books, Authors, and Categories with JWT Authentication and Role-Based Access Control

<br/>

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-Auth-black?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

</div>

---

## 📑 Table of Contents

- [Project Overview](#-project-overview)
- [Project Highlights](#-project-highlights)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Architecture](#-project-architecture)
- [Folder Structure](#-folder-structure)
- [Database Design](#-database-design)
- [Authentication](#-authentication)
- [Authorization](#-authorization)
- [JWT Authentication Flow](#-jwt-authentication-flow)
- [API Endpoints](#-api-endpoints)
- [File Upload & Download](#-file-upload--download)
- [Dashboard](#-dashboard)
- [Validation](#-validation)
- [Exception Handling](#-exception-handling)
- [API Documentation (Swagger)](#-api-documentation-swagger)
- [Local Installation](#-local-installation)
- [Screenshots](#-screenshots)
- [Future Improvements](#-future-improvements)
- [What I Learned](#-what-i-learned)
- [Author](#-author)

---

## 📖 Project Overview

**BookVerse API** is a backend application built using **Spring Boot**. It allows users to manage **books, authors, categories, and users** in a secure way.

The project uses **JWT Authentication** and **Role-Based Authorization** to keep the data safe. Two types of users can use this system:

- **Admin** – Can manage everything (add, update, delete books, authors, and categories).
- **User** – Can only view and search books, and download files.

This project follows a clean **layered architecture** (Controller → Service → Repository) which is a standard practice in real-world backend applications.

---

## 🌟 Project Highlights

- 🔐 Secure login system using **JWT** and **BCrypt password encryption**
- 🎯 Clean **Role-Based Access Control** for Admin and User
- 📚 Full **CRUD operations** for Books, Authors, and Categories
- 🔍 **Search, Pagination, and Sorting** support for books
- 📁 **File upload/download** for book cover images and PDFs
- 📊 **Dashboard API** with total counts of books, authors, categories, and users
- 🧪 **Global exception handling** for clean and consistent error responses
- 📘 Fully documented APIs using **Swagger UI**
- 🏗️ Built using **DTOs and Mappers** to follow clean coding standards

---

## ✨ Features

### 📕 Book Management

| Feature | Description |
|---|---|
| Add Book | Admin can add a new book to the system |
| Update Book | Admin can update details of an existing book |
| Delete Book | Admin can remove a book from the system |
| Get All Books | Anyone can view the complete list of books |
| Get Book By Id | Fetch details of a single book using its ID |
| Search Books | Search books by keywords like title or author |
| Pagination | View books in small pages instead of one long list |
| Sorting | Sort books by fields like title, in ascending or descending order |

### ✍️ Author Management

| Feature | Description |
|---|---|
| Add Author | Admin can add a new author |
| Update Author | Admin can update author details |
| Delete Author | Admin can remove an author |
| Get All Authors | View the complete list of authors |

### 🏷️ Category Management

| Feature | Description |
|---|---|
| Add Category | Admin can create a new book category |
| Update Category | Admin can update an existing category |
| Delete Category | Admin can delete a category |
| Get All Categories | View the complete list of categories |

### 🔑 User Authentication

| Feature | Description |
|---|---|
| Register | New users can create an account |
| Login | Existing users can log in |
| BCrypt Password Encryption | Passwords are encrypted before saving to the database |
| JWT Token Generation | A secure token is generated after successful login |
| JWT Authentication | Each request is verified using the JWT token |
| Stateless Authentication | Server does not store session data; everything is verified using the token |

### 🛡️ Role-Based Authorization

| Role | Access |
|---|---|
| **ADMIN** | Full access – manage Books, Authors, Categories, upload/download files, view Dashboard |
| **USER** | View Books, Authors, Categories, search books, download cover image and PDF |

### 📂 File Management

| Feature | Description |
|---|---|
| Upload Cover Image | Admin can upload a cover image for a book |
| View Cover Image | Anyone can view the uploaded cover image |
| Upload PDF | Admin can upload the PDF of a book |
| Open PDF | Anyone can open/download the uploaded PDF |

### 📊 Dashboard

| Feature | Description |
|---|---|
| Total Books | Shows the total number of books in the system |
| Total Authors | Shows the total number of authors |
| Total Categories | Shows the total number of categories |
| Total Users | Shows the total number of registered users |

---

## 🛠️ Tech Stack

| Category | Technology |
|---|---|
| **Language** | Java 21 |
| **Backend Framework** | Spring Boot, Spring MVC, Spring Security |
| **Database** | MySQL |
| **Authentication** | JWT (JSON Web Token) |
| **ORM** | Spring Data JPA, Hibernate |
| **Validation** | Jakarta Validation |
| **Documentation** | Swagger (OpenAPI) |
| **Build Tool** | Maven |

---

## 🏗️ Project Architecture

The project follows a simple **layered architecture**, which keeps the code organized and easy to maintain.

```
┌────────────────┐
│     Client      │
└────────┬────────┘
         │
         ▼
┌────────────────┐
│   Controller     │   →  Handles incoming HTTP requests
└────────┬────────┘
         │
         ▼
┌────────────────┐
│    Service       │   →  Contains business logic
└────────┬────────┘
         │
         ▼
┌────────────────┐
│   Repository     │   →  Talks to the database
└────────┬────────┘
         │
         ▼
┌────────────────┐
│  MySQL Database  │
└────────────────┘
```

---

## 📁 Folder Structure

```
src
 ├── config          → Application configuration classes
 ├── controller       → REST API controllers
 ├── dto              → Data Transfer Objects
 ├── entity            → Database entity classes
 ├── exception         → Custom exceptions and global handler
 ├── mapper            → Converts entities to DTOs and back
 ├── repository        → Database repositories (JPA)
 ├── security           → JWT and Spring Security configuration
 ├── service            → Service interfaces
 ├── service/impl        → Service implementation classes
 └── BookverseApiApplication.java
```

---

## 🗄️ Database Design

The database contains the following main tables:

| Table | Purpose |
|---|---|
| `users` | Stores registered users and their roles |
| `books` | Stores book details |
| `authors` | Stores author details |
| `categories` | Stores book category details |

---

## 🔐 Authentication

BookVerse API uses **JWT (JSON Web Token)** based authentication, which means:

- Users log in using their **email and password**.
- Passwords are stored securely using **BCrypt encryption**.
- On successful login, the server generates a **JWT token**.
- This token must be sent with every future request to prove the user's identity.
- The API is **stateless**, meaning the server does not need to remember who is logged in — the token itself carries that information.

---

## 🛡️ Authorization

Access to APIs is controlled using **roles**:

| Access Type | Endpoints |
|---|---|
| **Public APIs** (no login required) | `/auth/**`, `/swagger-ui/**`, `/v3/api-docs/**` |
| **Protected APIs** (login required) | `/books/**`, `/authors/**`, `/categories/**` |

| Role | Description |
|---|---|
| `ROLE_ADMIN` | Full access to manage all resources |
| `ROLE_USER` | Limited, read-only style access |

---

## 🔄 JWT Authentication Flow

```
          ┌───────────────┐
          │   User Login    │
          └───────┬───────┘
                  │  (Email + Password)
                  ▼
          ┌───────────────┐
          │ Spring Security │
          └───────┬───────┘
                  │
                  ▼
          ┌───────────────┐
          │ BCrypt Password │
          │      Check       │
          └───────┬───────┘
                  │
                  ▼
          ┌───────────────┐
          │ JWT Generation  │
          └───────┬───────┘
                  │
                  ▼
          ┌───────────────┐
          │  Bearer Token   │  →  Sent with every request
          └───────┬───────┘
                  │
                  ▼
          ┌───────────────┐
          │  JWT Filter      │  →  Validates the token
          └───────┬───────┘
                  │
                  ▼
          ┌───────────────┐
          │ Security Context│
          └───────┬───────┘
                  │
                  ▼
          ┌───────────────┐
          │ Role Verification│
          └───────┬───────┘
                  │
                  ▼
          ┌───────────────┐
          │   Controller     │
          └───────┬───────┘
                  │
                  ▼
          ┌───────────────┐
          │    Response      │
          └───────────────┘
```

---

## 📡 API Endpoints

### 🔑 Auth APIs

| Method | Endpoint | Access |
|---|---|---|
| POST | `/auth/register` | Public |
| POST | `/auth/login` | Public |

### 📕 Book APIs

| Method | Endpoint | Access |
|---|---|---|
| GET | `/books` | User / Admin |
| GET | `/books/{id}` | User / Admin |
| POST | `/books` | Admin |
| PUT | `/books/{id}` | Admin |
| DELETE | `/books/{id}` | Admin |

<details>
<summary><strong>🔍 Search, Pagination & Sorting APIs (click to expand)</strong></summary>

| Method | Endpoint | Access | Description |
|---|---|---|---|
| GET | `/books/search` | User / Admin | Search books by keyword |
| GET | `/books?page=0&size=5` | User / Admin | Get books with pagination |
| GET | `/books?sortBy=title&direction=asc` | User / Admin | Get books sorted by a field |

</details>

### ✍️ Author APIs

| Method | Endpoint | Access |
|---|---|---|
| GET | `/authors` | User / Admin |
| POST | `/authors` | Admin |
| PUT | `/authors/{id}` | Admin |
| DELETE | `/authors/{id}` | Admin |

### 🏷️ Category APIs

| Method | Endpoint | Access |
|---|---|---|
| GET | `/categories` | User / Admin |
| POST | `/categories` | Admin |
| PUT | `/categories/{id}` | Admin |
| DELETE | `/categories/{id}` | Admin |

<details>
<summary><strong>📁 File Upload / Download APIs (click to expand)</strong></summary>

| Method | Endpoint | Access | Description |
|---|---|---|---|
| POST | `/books/{id}/cover` | Admin | Upload cover image |
| GET | `/books/{id}/cover` | User / Admin | View cover image |
| POST | `/books/{id}/pdf` | Admin | Upload book PDF |
| GET | `/books/{id}/pdf` | User / Admin | Open/download book PDF |

</details>

### 📊 Dashboard API

| Method | Endpoint | Access |
|---|---|---|
| GET | `/dashboard/stats` | Admin |

---

## 📂 File Upload & Download

BookVerse API allows Admin users to upload files related to books:

| File Type | Storage Location |
|---|---|
| Cover Images | `uploads/covers` |
| PDF Files | `uploads/pdfs` |

> **Note:** Only the file names are stored in the database. The actual files are saved on the server's file system.

---

## 📊 Dashboard

The Dashboard API gives a quick summary of the whole system, including:

- Total number of Books
- Total number of Authors
- Total number of Categories
- Total number of Users

This is useful for Admin users to get a quick overview of the platform.

---

## ✅ Validation

The API validates incoming requests to make sure the data is correct before saving it:

| Validation Type | Description |
|---|---|
| Request Validation | Checks that required fields are filled correctly |
| Email Validation | Makes sure the email is in a valid format |
| Required Field Validation | Ensures important fields are not left empty |

---

## ⚠️ Exception Handling

BookVerse API uses **Global Exception Handling** to return clean and consistent error messages instead of raw server errors.

| Exception | When It Occurs |
|---|---|
| Book Not Found Exception | When a requested book does not exist |
| Validation Exception | When request data fails validation rules |
| Runtime Exception | For any other unexpected errors |

---

## 📘 API Documentation (Swagger)

All APIs are documented using **Swagger UI**, making it easy to explore and test endpoints directly from the browser.

**Swagger URL (Local):**

```
http://localhost:8080/swagger-ui/index.html
```

---

## ⚙️ Local Installation

Follow these steps to run BookVerse API on your local machine:

**1. Clone the repository**

```bash
git clone <repository-url>
```

**2. Open the project**

Open the project folder in **IntelliJ IDEA** (or any preferred Java IDE).

**3. Create a MySQL database**

```sql
CREATE DATABASE bookverse;
```

**4. Update `application.properties`**

Set your own MySQL credentials:

```properties
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
```

**5. Run the application**

Run the `BookverseApiApplication` class.

**6. Server will start on**

```
http://localhost:8080
```

---

## 🖼️ Screenshots

> Screenshots will be added soon.

| Screen | Preview |
|---|---|
| Swagger UI | *(add screenshot here)* |
| Login Response | *(add screenshot here)* |
| Dashboard | *(add screenshot here)* |

---

## 🚀 Future Improvements

- [ ] Email Verification
- [ ] Forgot Password
- [ ] Refresh Token
- [ ] Docker Support
- [ ] Redis Caching
- [ ] Unit Testing
- [ ] Cloud Storage for files
- [ ] Logging
- [ ] CI/CD Pipeline

---

## 🎓 What I Learned

Building this project helped me learn and practice the following:

- Spring Boot & Spring MVC
- REST API Development
- CRUD Operations
- DTOs and Mappers
- Request Validation
- Global Exception Handling
- Spring Data JPA & Hibernate
- MySQL Integration
- Spring Security
- JWT Authentication
- Role-Based Authorization
- BCrypt Password Encryption
- Pagination, Sorting & Searching
- Swagger API Documentation
- File Upload & Download
- Dashboard API Development
- Layered Architecture

---

## 👤 Author

**Mohammad Anas**

🔗 GitHub: [github.com/Anas-sk02](https://github.com/Anas-sk02)

---

<div align="center">

### ⭐ If you found this project useful, consider giving it a star!

Made with ☕ and Spring Boot by **Mohammad Anas**

</div>
