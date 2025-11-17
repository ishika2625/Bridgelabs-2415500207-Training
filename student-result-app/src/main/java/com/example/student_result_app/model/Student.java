package com.example.student_result_app.model;

public class Student {
    private int id; // DB PK
    private String rollNo;
    private String name;
    private String course;
    private int totalMarks;
    private String grade;

    public Student() {}

    public Student(String rollNo, String name, String course, int totalMarks, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.totalMarks = totalMarks;
        this.grade = grade;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public int getTotalMarks() { return totalMarks; }
    public void setTotalMarks(int totalMarks) { this.totalMarks = totalMarks; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return String.format("Student[id=%d, roll=%s, name=%s, course=%s, marks=%d, grade=%s]",
                id, rollNo, name, course, totalMarks, grade);
    }
}
