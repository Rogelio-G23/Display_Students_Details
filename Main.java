package com.mycompany.main;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentRepository repo = new StudentRepository();
        Scanner scanner = new Scanner();
        int choice;

        do{
            System.out.println(\n==================== MENU ====================");
            System.out.println(" 1. View All Students");
            System.out.println(" 2. Add Student");
            System.out.println(" 3. Exit");
            System.out.println("==============================================");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice){
                case 1:
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
                    break;

                case 2:
                    repo.addStudent(scanner);
                    break;

                case 3:
                    System.out.println("Exiting...")
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        }while(choice != 0);

        repo.close();
        scanner.close();
    }
}
