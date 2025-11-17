package com.example.student_result_app.db;

import java.sql.*;
import com.example.student_result_app.model.Student;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private String url;
    private String user;
    private String password;

    // Pass connection details
    public DatabaseManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        // Ensure driver loaded (not strictly needed for modern JDBC)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
        }
    }

    // Create (insert)
    public boolean addStudent(Student s) {
        String sql = "INSERT INTO students (roll_no, name, course, total_marks, grade) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, s.getRollNo());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getTotalMarks());
            ps.setString(5, s.getGrade());
            int affected = ps.executeUpdate();
            if (affected == 1) {
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) s.setId(keys.getInt(1));
                }
                return true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Duplicate roll number: " + s.getRollNo());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Read all
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id, roll_no, name, course, total_marks, grade FROM students";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setRollNo(rs.getString("roll_no"));
                s.setName(rs.getString("name"));
                s.setCourse(rs.getString("course"));
                s.setTotalMarks(rs.getInt("total_marks"));
                s.setGrade(rs.getString("grade"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Read by roll number
    public Student findByRoll(String rollNo) {
        String sql = "SELECT id, roll_no, name, course, total_marks, grade FROM students WHERE roll_no = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, rollNo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Student s = new Student();
                    s.setId(rs.getInt("id"));
                    s.setRollNo(rs.getString("roll_no"));
                    s.setName(rs.getString("name"));
                    s.setCourse(rs.getString("course"));
                    s.setTotalMarks(rs.getInt("total_marks"));
                    s.setGrade(rs.getString("grade"));
                    return s;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update
    public boolean updateStudentByRoll(Student s) {
        String sql = "UPDATE students SET name=?, course=?, total_marks=?, grade=? WHERE roll_no=?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setInt(3, s.getTotalMarks());
            ps.setString(4, s.getGrade());
            ps.setString(5, s.getRollNo());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete
    public boolean deleteByRoll(String rollNo) {
        String sql = "DELETE FROM students WHERE roll_no=?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, rollNo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
