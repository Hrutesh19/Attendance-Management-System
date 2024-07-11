package presentation;

import java.util.List;
import java.util.Scanner;
import java.util.Date;

import java.sql.SQLException;
import model.Attendance;
import service.AttendanceService;

public class AttendanceUI {
    private AttendanceService attendanceService;
    private Scanner scanner;

    public AttendanceUI() throws SQLException {
        attendanceService = new AttendanceService();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance by Student ID");
            System.out.println("3. View All Attendance");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    markAttendance();
                    break;
                case 2:
                    viewAttendanceByStudentId();
                    break;
                case 3:
                    viewAllAttendance();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void markAttendance() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter date (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();
        Date date = java.sql.Date.valueOf(dateString);
        System.out.print("Enter attendance status (Present/Absent): ");
        String status = scanner.nextLine();
        attendanceService.markAttendance(new Attendance(studentId, date, status));
        System.out.println("Attendance marked successfully.");
    }

    private void viewAttendanceByStudentId() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        List<Attendance> attendances = attendanceService.getAttendanceByStudentId(studentId);
        for (Attendance attendance : attendances) {
            System.out.println("Student ID: " + attendance.getStudentId() + ", Date: " + attendance.getDate() + ", Status: " + attendance.getStatus());
        }
    }

    private void viewAllAttendance() {
        List<Attendance> attendances = attendanceService.getAllAttendances();
        for (Attendance attendance : attendances) {
            System.out.println("Student ID: " + attendance.getStudentId() + ", Date: " + attendance.getDate() + ", Status: " + attendance.getStatus());
        }
    }
}
