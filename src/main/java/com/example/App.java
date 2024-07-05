package com.example;

import com.example.service.StudentService;
import com.example.util.Constants;
import com.example.util.GradeCalculator;
import com.example.model.Student;

import java.util.Map;
import java.util.Scanner;

public class App {
    private final StudentService studentService = new StudentService();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    listStudents();
                    break;
                case 5:
                    calculateAverageGrade();
                    break;
                case 6:
                    findHighestGrade();
                    break;
                case 7:
                    findLowestGrade();
                    break;
                case 8:
                    search();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nStudent Grades Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. List All Students");
        System.out.println("5. Calculate Average Grade");
        System.out.println("6. Find Highest Grade");
        System.out.println("7. Find Lowest Grade");
        System.out.println("8. Search Student");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        double grade = Constants.INITIAL_GRADE_CONSTANT;
        while (grade < Constants.MIN_GRADE || grade > Constants.MAX_GRADE) {
            System.out.print("Enter student grade: ");
            if (scanner.hasNextDouble()) {
                grade = scanner.nextDouble();
                if (grade < Constants.MIN_GRADE || grade > Constants.MAX_GRADE) {
                    System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid grade (numeric value).");
                scanner.next(); // Consume the invalid input
            }
            scanner.nextLine(); // Consume newline
        }


        if (studentService.addStudent(name, grade)) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Failed to add student. Invalid input.");
        }
    }

    private void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new student grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        if (studentService.updateStudent(id, name, grade)) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Failed to update student. Invalid input or ID not found.");
        }
    }

    private void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (studentService.deleteStudent(id)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Failed to delete student. ID not found.");
        }
    }

    private void listStudents() {
        Map<Integer, Student> students = studentService.listStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("List of students:");
            for (Student student : students.values()) {
                System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Grade: " + student.getGrade());
            }
        }
    }

    private void calculateAverageGrade() {
        // Implementation will be provided later
         double avgGrade = studentService.calculateAverage();

         System.out.println("Average Grade :  " + avgGrade);
    }

    private void findHighestGrade() {
        // Implementation will be provided later

        double highest = studentService.getHighestGrade();
        System.out.println("Highest grade" + highest);
    }

    private void findLowestGrade() {
        // Implementation will be provided later
    }
    public void search(){
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        if(studentService.searchStudent(name)){
            System.out.println("student found");
        }
        else System.out.println("student not found");

    }
}
