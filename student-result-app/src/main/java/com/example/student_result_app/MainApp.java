package com.example.student_result_app;

import com.example.student_result_app.db.DatabaseManager;
import com.example.student_result_app.model.Student;
import com.example.student_result_app.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        // Update connection details here:
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "1239"; // change!

        DatabaseManager db = new DatabaseManager(url, user, password);
        StudentService service = new StudentService(db);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Student Result Management ===");
            System.out.println("1. Add student");
            System.out.println("2. List all students");
            System.out.println("3. Find by roll no");
            System.out.println("4. Update student");
            System.out.println("5. Delete student");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine().trim();
            try {
                switch (choice) {
                    case "1":
                        System.out.print("Roll no: "); String roll = sc.nextLine();
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Course: "); String course = sc.nextLine();
                        System.out.print("Total marks: "); int marks = Integer.parseInt(sc.nextLine());
                        System.out.print("Grade: "); String grade = sc.nextLine();
                        Student s = new Student(roll, name, course, marks, grade);
                        boolean added = service.addStudent(s);
                        System.out.println(added ? "Added." : "Failed to add.");
                        break;
                    case "2":
                        List<Student> list = service.listStudents();
                        list.forEach(System.out::println);
                        break;
                    case "3":
                        System.out.print("Roll no: ");
                        String r = sc.nextLine();
                        Student found = service.findByRoll(r);
                        System.out.println(found == null ? "Not found." : found);
                        break;
                    case "4":
                        System.out.print("Roll no to update: ");
                        String ur = sc.nextLine();
                        Student up = service.findByRoll(ur);
                        if (up == null) { System.out.println("Not found."); break; }
                        System.out.print("New name ("+up.getName()+"): "); String nn = sc.nextLine();
                        if (!nn.isBlank()) up.setName(nn);
                        System.out.print("New course ("+up.getCourse()+"): "); String nc = sc.nextLine();
                        if (!nc.isBlank()) up.setCourse(nc);
                        System.out.print("New marks ("+up.getTotalMarks()+"): "); String nm = sc.nextLine();
                        if (!nm.isBlank()) up.setTotalMarks(Integer.parseInt(nm));
                        System.out.print("New grade ("+up.getGrade()+"): "); String ng = sc.nextLine();
                        if (!ng.isBlank()) up.setGrade(ng);
                        boolean updated = service.updateStudent(up);
                        System.out.println(updated ? "Updated." : "Update failed.");
                        break;
                    case "5":
                        System.out.print("Roll no to delete: ");
                        String dr = sc.nextLine();
                        boolean del = service.deleteByRoll(dr);
                        System.out.println(del ? "Deleted." : "Delete failed.");
                        break;
                    case "0":
                        System.out.println("Bye.");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid number input.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
