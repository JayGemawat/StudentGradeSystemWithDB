# 🎓 Student Grade Management System (Java + MySQL)

A simple console-based Java application that allows users to manage student records, calculate total marks and grades, and store data securely in a MySQL database using JDBC.

---

## 📌 Features

- ➕ Add new student records
- 📄 View all student data
- 🧮 Auto-calculates total and average marks
- 🏆 Grade calculation based on average
- 💾 Stores data in a MySQL database using JDBC

---

## 🧱 Tech Stack

| Technology      | Usage                          |
|-----------------|--------------------------------|
| Java (Core)     | Application logic              |
| MySQL           | Database for persistence       |
| JDBC            | Java-MySQL connectivity        |
| Spring Boot     | IDE for development            |

---

## 🗃️ Database Setup

Make sure MySQL is installed and running on `localhost:3306`.  
Then run the following SQL to create the necessary database and table:

```sql
CREATE DATABASE IF NOT EXISTS Learning;

USE Learning;

CREATE TABLE IF NOT EXISTS students (
    roll_no INT PRIMARY KEY,
    name VARCHAR(100),
    marks1 INT,
    marks2 INT,
    marks3 INT
);
