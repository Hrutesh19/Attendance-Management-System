package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Teacher;
import util.DBConnection;

public class TeacherDAO {
    private Connection connection;

    public TeacherDAO() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public void addTeacher(Teacher teacher) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO teachers (id, name, class) VALUES (?, ?, ?)");
            ps.setInt(1, teacher.getId());
            ps.setString(2, teacher.getName());
            ps.setString(3, teacher.getClassName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacher(Teacher teacher) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE teachers SET name = ?, class = ? WHERE id = ?");
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getClassName());
            ps.setInt(3, teacher.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTeacher(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM teachers WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM teachers");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                teachers.add(new Teacher(rs.getInt("id"), rs.getString("name"), rs.getString("class")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
}
