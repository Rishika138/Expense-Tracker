# Expense-Tracker
A console-based Expense Tracker application built with Java, JDBC, and JSON. 
This project helps users to manage their personal expenses with CRUD operations and stores data in a MySQL database. 

---

Features
- Add new expense/transaction  
- View all expenses  
- Update existing expenses  
- Delete expenses  
- Store & retrieve expenses from **MySQL database**  
- Export transactions to **JSON file**   

---

Technologies Used
- Java (Core Java, OOP, Collections, Exception Handling)
- JDBC for database connectivity
- MySQL as the database
- Jackson Library for JSON handling
- java.time API for Date & Time
- JUnit for unit testing
- Logging (java.util.logging / Log4j)

---

Project Structure

Expense-Tracker/
│
├── src/
│ ├── com.exp_tracker/ (Main application)
│ ├── com.exp_tracker.db/ (database connection)
│ ├── com.exp_tracker.dao/ (DAO [CRUD methods])
│ ├── com.exp_tracker.model/ (Transaction model classes)
│ ├── com.exp_tracker.service/ ( classes)
│ ├── com.exp_tracker.util/ (JSON utils)
│
├── data/ (JSON Export file)
├── output_ss/ (screenshots of output) 
└── README.md

---

Output 

### Add Expense
<img width="837" height="340" alt="main" src="https://github.com/user-attachments/assets/24f6e94e-4576-44ce-be1c-93429902ebf0" />

