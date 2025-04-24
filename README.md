Student Management System
A Java-based Student Management System (SMS) that allows admins to manage student records using JDBC and MySQL for database management. This system includes features to add, view, search, and update student information.

Features
Add Student: Admin can add new students to the database.

View Students: Admin can view the list of all students in a table format.

Search Student: Admin can search students by Student ID.

Update Student: Admin can update the details of an existing student (Name, Age, Grade, Email).

Technologies Used
Java (Core Java)

Swing (for GUI)

MySQL (for database management)

JDBC (for database connection)

Prerequisites
MySQL installed on your machine.

JDBC library added to your Java project (for MySQL connection).

MySQL Workbench or any MySQL client to manage the database.

Setup Instructions
1. Clone the Repository
bash
Copy
Edit
git clone https://github.com/yourusername/student-management-system.git
2. Database Setup
Run the following SQL script in MySQL Workbench to create the database and the required table:

sql
Copy
Edit
-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS student_db;

-- Use the created database
USE student_db;

-- Create students table
CREATE TABLE IF NOT EXISTS students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    grade VARCHAR(10),
    email VARCHAR(100)
);
3. Configure Database Connection
Update the DBConnection.java file with your MySQL credentials.

java
Copy
Edit
public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db", "root", "yourpassword"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
Replace "yourpassword" with your actual MySQL root password.

4. Run the Application
Run the MainFrame.java file to launch the application. The GUI will appear with options to:

Add a new student.

View the list of students.

Search for a student by ID.

Update student information.

How to Use the Application
1. Add Student
Click on the Add Student button in the sidebar.

Fill out the form and click Add to save the student data.

2. View Students
Click on the View Students button to see a list of all students in the database.

3. Search Student
Click on the Search Student button.

Enter the Student ID and click Search to load the student's information.

4. Update Student
Click on the Update Student button.

Enter the Student ID to search for a student, then modify the details and click Update to save changes.

