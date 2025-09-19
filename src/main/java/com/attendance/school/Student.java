package com.attendance.school;

public class Student {
    private static int nextStudentIdCounter = 1; // auto-increment counter
    private int studentId;
    private String name;

    // Constructor
    public Student(String name) {
        this.studentId = nextStudentIdCounter++;
        this.name = name;
    }

    public void displayDetails() {
        System.out.println("Student ID: S" + studentId);
        System.out.println("Name: " + name);
    }
}

