package service;

import java.sql.SQLException;
import java.util.List;

import dao.StudentDAO;
import model.Student;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() throws SQLException {
        studentDAO = new StudentDAO();
    }

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
