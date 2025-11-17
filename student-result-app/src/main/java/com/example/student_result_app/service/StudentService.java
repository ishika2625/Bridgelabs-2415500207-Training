package com.example.student_result_app.service;

import com.example.student_result_app.model.Student;
import com.example.student_result_app.db.DatabaseManager;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private DatabaseManager db;
    private List<Student> cache; // in-memory list

    public StudentService(DatabaseManager db) {
        this.db = db;
        this.cache = new ArrayList<>();
        loadCacheFromDb();
    }

    private void loadCacheFromDb() {
        cache.clear();
        cache.addAll(db.getAllStudents());
    }

    public boolean addStudent(Student s) {
        boolean ok = db.addStudent(s);
        if (ok) cache.add(s);
        return ok;
    }

    public List<Student> listStudents() {
        return new ArrayList<>(cache);
    }

    public Student findByRoll(String roll) {
        return db.findByRoll(roll);
    }

    public boolean updateStudent(Student s) {
        boolean ok = db.updateStudentByRoll(s);
        if (ok) loadCacheFromDb();
        return ok;
    }

    public boolean deleteByRoll(String roll) {
        boolean ok = db.deleteByRoll(roll);
        if (ok) loadCacheFromDb();
        return ok;
    }
}
