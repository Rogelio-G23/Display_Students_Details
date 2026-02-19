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

    // Close the database connection when done
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}
