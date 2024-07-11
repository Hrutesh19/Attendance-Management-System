package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Attendance;
import util.DBConnection;

public class AttendanceDAO {
    private Connection connection;

    public AttendanceDAO() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public void markAttendance(Attendance attendance) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO attendance (student_id, date, status) VALUES (?, ?, ?)");
            ps.setInt(1, attendance.getStudentId());
            ps.setDate(2, new java.sql.Date(attendance.getDate().getTime()));
            ps.setString(3, attendance.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Attendance> getAttendanceByStudentId(int studentId) {
        List<Attendance> attendances = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM attendance WHERE student_id = ?");
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                attendances.add(new Attendance(rs.getInt("student_id"), rs.getDate("date"), rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }

    public List<Attendance> getAllAttendances() {
        List<Attendance> attendances = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM attendance");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                attendances.add(new Attendance(rs.getInt("student_id"), rs.getDate("date"), rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }
}
