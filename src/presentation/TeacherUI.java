package presentation;

import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;

import model.Teacher;
import service.TeacherService;

public class TeacherUI {
    private TeacherService teacherService;
    private Scanner scanner;

    public TeacherUI() {
        try {
            teacherService = new TeacherService();
            scanner = new Scanner(System.in);
        } catch (SQLException e) {
            System.out.println("Error occurred while initializing TeacherService: " + e.getMessage());
        }
    }

    public void menu() {
        while (true) {
            System.out.println("1. Add Teacher");
            System.out.println("2. Update Teacher");
            System.out.println("3. Delete Teacher");
            System.out.println("4. View All Teachers");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    updateTeacher();
                    break;
                case 3:
                    deleteTeacher();
                    break;
                case 4:
                    viewAllTeachers();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addTeacher() {
        System.out.print("Enter teacher ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();
        System.out.print("Enter class: ");
        String className = scanner.nextLine();
        teacherService.addTeacher(new Teacher(id, name, className));
        System.out.println("Teacher added successfully.");
    }

    private void updateTeacher() {
        System.out.print("Enter teacher ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new teacher name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new class: ");
        String className = scanner.nextLine();
        teacherService.updateTeacher(new Teacher(id, name, className));
        System.out.println("Teacher updated successfully.");
    }

    private void deleteTeacher() {
        System.out.print("Enter teacher ID: ");
        int id = scanner.nextInt();
        teacherService.deleteTeacher(id);
        System.out.println("Teacher deleted successfully.");
    }

    private void viewAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        for (Teacher teacher : teachers) {
            System.out.println("ID: " + teacher.getId() + ", Name: " + teacher.getName() + ", Class: " + teacher.getClassName());
        }
    }
}
