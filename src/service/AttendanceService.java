package service;

import java.sql.SQLException;
import java.util.List;

import dao.AttendanceDAO;
import model.Attendance;

public class AttendanceService {
    private AttendanceDAO attendanceDAO;

    public AttendanceService() throws SQLException {
        attendanceDAO = new AttendanceDAO();
    }

    public void markAttendance(Attendance attendance) {
        attendanceDAO.markAttendance(attendance);
    }

    public List<Attendance> getAttendanceByStudentId(int studentId) {
        return attendanceDAO.getAttendanceByStudentId(studentId);
    }

    public List<Attendance> getAllAttendances() {
        return attendanceDAO.getAllAttendances();
    }
}
