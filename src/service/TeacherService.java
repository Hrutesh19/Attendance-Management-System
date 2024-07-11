package service;

import java.sql.SQLException;
import java.util.List;

import dao.TeacherDAO;
import model.Teacher;

public class TeacherService {
    private TeacherDAO teacherDAO;

    public TeacherService() throws SQLException {
        teacherDAO = new TeacherDAO();
    }

    public void addTeacher(Teacher teacher) {
        teacherDAO.addTeacher(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        teacherDAO.updateTeacher(teacher);
    }

    public void deleteTeacher(int id) {
        teacherDAO.deleteTeacher(id);
    }

    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }
}
