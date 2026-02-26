package com.mycompany.main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private Connection connection;

    // Connect to the database when Repository is created
    public StudentRepository() {
        try {
            // Load the SQLite JDBC driver first
            Class.forName("org.sqlite.JDBC");

            // Path to your Students.db file
            String url = "jdbc:sqlite:C:/Users/Rogelio/Documents/NetBeansProjects/Main/Students.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to database!");

        } catch (ClassNotFoundException e) {
            System.out.println("SQLite driver not found. Make sure sqlite-jdbc.jar is in your Libraries.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    // Get all students from the database and return them as a List
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try {
            String    sql  = "SELECT * FROM tbl_StudentDetails";
            Statement stmt = connection.createStatement();
            ResultSet rs   = stmt.executeQuery(sql);

            while (rs.next()) {
                // Use the Builder to create each Student object
                Student s = new Student.Builder()
                    .studentId(rs.getString("studentId"))
                    .name(rs.getString("name"))
                    .gender(rs.getString("gender"))
                    .course(rs.getString("course"))
                    .address(rs.getString("address"))
                    .nationality(rs.getString("nationality"))
                    .age(rs.getInt("age"))
                    .year(rs.getInt("year"))
                    .section(rs.getInt("section"))
                    .contactNo(rs.getInt("contactNo"))
                    .build();
                list.add(s);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error getting students: " + e.getMessage());
        }
        return list;
    }


    // Updated the database with addStudent() and INSERT INTO table the data I entered
    public void addStudent(Scanner scanner) {

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Nationality: ");
        String nationality = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Year: ");
        int year = scanner.nextInt();

        System.out.print("Enter Section: ");
        int section = scanner.nextInt();

        System.out.print("Enter Contact No: ");
        int contactNo = scanner.nextInt();
        scanner.nextLine();

        String sql = "INSERT INTO tbl_StudentDetails (studentId, name, gender, course, address, nationality, age, year, section, contactNo) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, studentId);
            pstmt.setString(2, name);
            pstmt.setString(3, gender);
            pstmt.setString(4, course);
            pstmt.setString(5, address);
            pstmt.setString(6, nationality);
            pstmt.setInt   (7, age);
            pstmt.setInt   (8, year);
            pstmt.setInt   (9, section);
            pstmt.setInt   (10, contactNo);

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            if (rowsAffected > 0) {
                System.out.println("Student added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Close the database connection when done
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}
