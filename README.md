# Student Information Management System

This project is a **Java-based GUI application** for managing student and department information in an academic environment. It allows users to add, view, and manage student and department records using a simple and interactive interface.

---

## Features

1. **Student Information Management**:
   - Add details such as Roll Number, Name, Class, and Department.
   - Validate input fields to ensure data integrity.

2. **Department Management**:
   - Add department details, including Department Name and auto-generated IDs.

3. **Interactive GUI**:
   - User-friendly interface built using Swing.
   - Buttons for submitting, clearing, and exiting forms.

4. **Database Connectivity**:
   - Uses **MySQL** for storing student and department records.
   - Integration via JDBC for seamless database interaction.

---

## Files in the Project

1. **`wellcome.java`**:
   - Main entry point of the application.
   - Provides navigation to different modules:
     - Adding Student Details.
     - Adding Department Details.
     - Viewing Student Details.

2. **`bhimahome.java`**:
   - Manages the Student Information form.
   - Allows data entry and saves records into the database.

3. **`department.java`**:
   - Handles Department Information.
   - Automatically generates unique Department IDs and saves data into the database.

---

## Files in the Project

1. **`wellcome.java`**:
   - Main entry point of the application.
   - Provides navigation to different modules:
     - Adding Student Details.
     - Adding Department Details.
     - Viewing Student Details.

   ![Welcome Screen](login1.png)

2. **`bhimahome.java`**:
   - Manages the Student Information form.
   - Allows data entry and saves records into the database.

   ![Student Information Screen](login2.png)

3. **`department.java`**:
   - Handles Department Information.
   - Automatically generates unique Department IDs and saves data into the database.

   ![Department Information Screen](login3.png)

---


## Database Setup

To run this project, set up the following MySQL database:

1. Create a database named `imca`.
2. Create the `Department` table:
   ```sql
   CREATE TABLE Department (
       dept_id INT AUTO_INCREMENT PRIMARY KEY,
       dept_name VARCHAR(100) NOT NULL
   );
   ```
3. Create the `Studence` table:
   ```sql
   CREATE TABLE Studence (
       Student_RollNo VARCHAR(20) PRIMARY KEY,
       Student_name VARCHAR(100) NOT NULL,
       Student_class VARCHAR(50),
       Department VARCHAR(100)
   );
   ```
4. Update the database connection details in the `DatabaseConnection` class (`bhimahome.java` and `department.java`):
   ```java
   String url = "jdbc:mysql://localhost:3306/imca"; 
   String user = "root"; 
   String password = "YourPassword"; 
   ```

---

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/bhiam108k/Student-Management.git
   ```
2. **Set Up the Database**:
   - Create the necessary tables as described above.
   - Update the database connection details in the Java files.

3. **Compile and Run**:
   - Use an IDE like **Eclipse** or **IntelliJ IDEA** to import and run the project.
   - Alternatively, compile and run using the command line:
     ```bash
     javac wellcome.java
     java wellcome
     ```

---

## Requirements

- **Java Development Kit (JDK)**: Version 8 or later.
- **MySQL Database**: Version 5.7 or later.
- **IDE (Optional)**: Eclipse, IntelliJ IDEA, or NetBeans.
