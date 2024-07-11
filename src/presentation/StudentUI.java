package presentation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Student;
import service.StudentService;

public class StudentUI {
    private StudentService studentService;
    private Scanner scanner;

    public StudentUI() throws SQLException {
        studentService = new StudentService();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

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
                    viewAllStudents();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter class: ");
        String className = scanner.nextLine();
        studentService.addStudent(new Student(id, name, className));
        System.out.println("Student added successfully.");
    }

    private void updateStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new class: ");
        String className = scanner.nextLine();
        studentService.updateStudent(new Student(id, name, className));
        System.out.println("Student updated successfully.");
    }

    private void deleteStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        studentService.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }

    private void viewAllStudents() {
        List<Student> students = studentService.getAllStudents();
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Class: " + student.getClassName());
        }
    }
}
