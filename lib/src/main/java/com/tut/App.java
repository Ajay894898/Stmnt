package com.tut;

import java.util.List;

public class App {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Add new students
        Student student1 = new Student("Ajay ydv1", "Aj.ydv1@example.com", "Computer Science", 2);
        studentDAO.addStudent(student1);

        Student student2 = new Student("Ajay ydv2", "Aj.ydv2@example.com", "Mathematics", 3);
        studentDAO.addStudent(student2);

        // List all students
        List<Student> students = studentDAO.listStudents();
        for (Student student : students) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Course: " + student.getCourse());
            System.out.println("Year: " + student.getYear());
            System.out.println("---------");
        }

        // Update a student
        studentDAO.updateStudent(student1.getId(), "Yadav Ajay", "Yadav.Aj@example.com", "Software Engineering", 3);

        // Delete a student
        studentDAO.deleteStudent(student2.getId());
    }
}
