package presentation;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        StudentUI studentUI = new StudentUI();
        TeacherUI teacherUI = new TeacherUI();
        AttendanceUI attendanceUI = new AttendanceUI();

        while (true) {
            System.out.println("1. Student Management");
            System.out.println("2. Teacher Management");
            System.out.println("3. Attendance Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentUI.menu();
                    break;
                case 2:
                    teacherUI.menu();
                    break;
                case 3:
                    attendanceUI.menu();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
