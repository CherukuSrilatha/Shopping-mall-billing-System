# Shopping Mall Billing System

## Description
This project is a **Shopping Mall Billing System** developed in **Java**. The system allows sales transactions to be processed and generates bills. The data is stored in a **MySQL database**.

### Files Included:
- `Dump20250509.sql`: SQL file for setting up the database and tables in MySQL.
- `ShoppingBill.java`: Java code for the billing system, which handles the logic for processing sales and generating bills.
- `ShoppingBill.class`: Compiled Java class file for running the program.

## How to Run

1. **Import the SQL File:**
   - Open MySQL Workbench or phpMyAdmin.
   - Run the `Dump20250509.sql` file to create the necessary database and tables for the billing system.

2. **Compile and Run the Java Program:**
   - **Compile** the Java code:
     ```bash
     javac ShoppingBill.java
     ```
   - **Run** the program:
     ```bash
     java ShoppingBill
     ```

## Installation Instructions

1. **Install MySQL**:
   - Make sure you have MySQL installed and running on your machine.
   - Use MySQL Workbench or phpMyAdmin to import the `Dump20250509.sql` file.

2. **Java Setup**:
   - Ensure you have **Java JDK** installed on your machine to compile and run the `ShoppingBill.java` program.

## Usage
- The program generates a bill based on sales data stored in the MySQL database.
- The user interacts with the system to create and view bills.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
