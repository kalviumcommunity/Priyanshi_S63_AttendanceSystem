package com.attendance;



public class Main {
    public static void main(String[] args) {
        // Create Students
    
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        s1.displayDetails();
        System.out.println("-----");
        s2.displayDetails();

        System.out.println("=======================");

        // Create Courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");

        c1.displayDetails();
        System.out.println("-----");
        c2.displayDetails();
    }
}
