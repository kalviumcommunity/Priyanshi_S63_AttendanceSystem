package components.school;

import java.util.ArrayList;
import java.util.List;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;

    private int courseId;       // Made private
    private String courseName;  // Made private
    private int capacity;       // Maximum number of students
    private List<Student> enrolledStudents; // List of enrolled students

    // Constructor
    public Course(String courseName, int capacity) {
        this.courseId = nextCourseIdCounter++; // Auto-increment and assign ID
        this.courseName = courseName;          // Assign course name
        this.capacity = capacity;              // Set course capacity
        this.enrolledStudents = new ArrayList<>(); // Initialize empty list
    }

    // Getter for courseId
    public int getCourseId() {
        return courseId;
    }

    // Getter for courseName
    public String getCourseName() {
        return courseName;
    }

    // Getter for capacity
    public int getCapacity() {
        return capacity;
    }

    // Getter for enrolledStudents list
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Getter for number of enrolled students
    public int getNumberOfEnrolledStudents() {
        return enrolledStudents.size();
    }

    // Method to add a student to the course
    public boolean addStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true; // Enrollment successful
        }
        return false; // Enrollment failed (capacity reached)
    }

    public void displayDetails() {
        System.out.println("Course ID: C" + this.courseId + 
                         ", Name: " + this.courseName + 
                         ", Capacity: " + this.capacity + 
                         ", Enrolled: " + getNumberOfEnrolledStudents() + "/" + this.capacity);
    }

    @Override
    public String toDataString() {
        // Format: courseId,courseName,capacity
        return courseId + "," + courseName + "," + capacity;
    }
}