# 🎓 Student DB — Java Terminal App

A terminal-based **Student Database Management System** built with **Java** and **JDBC**, connected to a **MySQL** database. Supports full CRUD operations with batch insert and prepared statements.

---

## 📋 Features

- ✅ Insert single or multiple students (with Batch Processing)
- ✅ Read student by ID
- ✅ Update student marks
- ✅ Delete student by ID
- ✅ View all students
- ✅ Duplicate ID protection (Primary Key constraint)
- ✅ SQL Injection safe (PreparedStatement)
- ✅ Credentials stored securely via `config.properties` (not pushed to GitHub)

---

## 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| Java | Core language |
| JDBC | Database connectivity |
| MySQL | Database |
| MySQL Connector/J 9.6.0 | JDBC Driver |

---

## 🗄️ Database Setup

Run the following in MySQL:

```sql
CREATE DATABASE practice;

USE practice;

CREATE TABLE students (
    id    INT PRIMARY KEY,
    name  VARCHAR(50),
    marks INT
);
```

---

## ⚙️ Configuration

This project uses a `config.properties` file to store database credentials securely.

1. Create a file at `src/config.properties`:

```properties
db.url=jdbc:mysql://localhost:3306/practice
db.user=your_mysql_username
db.password=your_mysql_password
```

2. A `config.properties.example` file is provided as a template.

> ⚠️ `config.properties` is listed in `.gitignore` and will **never** be pushed to GitHub.

---

## 🚀 How to Run

1. Clone the repository:
```bash
git clone https://github.com/a-d-it-ya/Student-DB-using-Java-terminal-.git
cd Student-DB-using-Java-terminal-
```

2. Add the MySQL Connector JAR to your project (in the `lib/` folder).

3. Create `src/config.properties` with your DB credentials (see above).

4. Run `UsingSwitch.java` from VS Code or terminal.

---

## 📂 Project Structure

```
JDBC/
├── src/
│   ├── FirstJdbcApp.java          # Basic JDBC with Statement
│   ├── UsingPrepared.java         # PreparedStatement CRUD
│   ├── UsingSwitch.java           # Menu-driven app (main file)
│   ├── config.properties          # ❌ ignored by git (your credentials)
│   └── config.properties.example  # ✅ template for setup
├── lib/
│   └── mysql-connector-j-9.6.0.jar
├── .gitignore
└── README.md
```

---

## 🖥️ Usage

When you run the app, you get a menu:

```
1. Insert
2. Read by ID
3. Update Marks
4. Delete
5. Show All
Enter your choice:
```

### Insert (supports batch — multiple students at once):
```
How many students to insert? 2
--- Student 1 ---
ID: 1
Name: Aditya
Marks: 95
--- Student 2 ---
ID: 2
Name: Rahul
Marks: 88
✅ Inserted 2 students!
```

---

## 📚 Concepts Covered

- JDBC Connection & DriverManager
- `Statement` vs `PreparedStatement`
- Batch Processing (`addBatch` / `executeBatch`)
- Transaction Management (`commit` / `rollback`)
- Primary Key constraint for duplicate prevention
- Secure credential management with `config.properties`

---

## 👨‍💻 Author

**Aditya** — Java & JDBC learning project
