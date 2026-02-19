package com.mycompany.main;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentRepository repo = new StudentRepository();

        List<Student> students = repo.getAllStudents();

        System.out.println("\n==================================================================================================================");
        System.out.println("                        STUDENT MASTER LIST                               ");
        System.out.println("==================================================================================================================");
        System.out.printf("%-12s %-20s %-8s %-8s %-5s %-5s %-8s %-11s %-15s %-20s%n",
                "ID", "Name", "Gender", "Course", "Age", "Year", "Section", "ContactNo", "Nationality", "Address");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-12s %-20s %-8s %-8s %-5d %-5d %-8d %-11s %-15s %-20s%n",
                s.getStudentId(),
                s.getName(),
                s.getGender(),
                s.getCourse(),
                s.getAge(),
                s.getYear(),
                s.getSection(),
                s.getContactNo(),
                s.getNationality(),
                s.getAddress()
            );
        }

        repo.close();
    }
}
