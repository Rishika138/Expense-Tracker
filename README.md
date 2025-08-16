# Expense-Tracker
A console-based Expense Tracker application built with Java, JDBC, and JSON. 
This project helps users to manage their personal expenses with CRUD operations and stores data in a MySQL database. 

---

### Features:

- Add new expense/transaction  
- View all expenses  
- Update existing expenses  
- Delete expenses  
- Store & retrieve expenses from MySQL database
- Export transactions to JSON file

---

### Technologies Used:

- Java (Core Java, OOP, Collections, Exception Handling)
- JDBC for database connectivity
- MySQL as the database
- Jackson Library for JSON handling

---

### Project Structure:

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

### Database Setup:

Run the following SQL commands in MySQL before running the app:

=> CREATE DATABASE exp_tracker;

=> create table transactions ( T_id int primary key auto_increment not null, T_title varchar(50) not null, T_amt int(50) not null, T_type varchar(50) not null, T_date date not null );

---

### Output:

### Main operations (start)
<img width="837" height="340" alt="main" src="https://github.com/user-attachments/assets/24f6e94e-4576-44ce-be1c-93429902ebf0" />

### Add Expense
<img width="836" height="253" alt="add_transaction" src="https://github.com/user-attachments/assets/d3be7424-8c0f-43fc-aef9-de977c81b559" />

### View Expenses
<img width="830" height="251" alt="view_transaction" src="https://github.com/user-attachments/assets/7e13c6d4-bd77-481d-b503-4c98352c6318" />

### Update Expense
<img width="850" height="427" alt="update_transaction" src="https://github.com/user-attachments/assets/9c5d03cf-4a0c-49a0-b1e2-edbd675fd74e" />

### Detele Expense
<img width="861" height="276" alt="delete_transaction" src="https://github.com/user-attachments/assets/bad5423c-41da-4a68-82c9-5c277a13a686" />

### Export Expense list
<img width="871" height="106" alt="export" src="https://github.com/user-attachments/assets/32e58dac-80d5-4b66-aada-4334d13afb4d" />

<img width="427" height="481" alt="expense-json" src="https://github.com/user-attachments/assets/36965569-c7e9-450a-a84d-6025ffc4c5a6" />

### Exit (end)
<img width="747" height="97" alt="exit" src="https://github.com/user-attachments/assets/6e89ca7e-dde1-463f-8f1f-330b90ce808e" />
















