package components.school;

public class Student {
    private static int nextStudentIdCounter = 1;

    private int studentId;    // Made private
    private String name;      // Made private

    // Constructor
    public Student(String name) {
        this.studentId = nextStudentIdCounter++; // Auto-increment and assign ID
        this.name = name;                      // Assign name
    }

    // Getter for studentId
    public int getStudentId() {
        return studentId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + this.studentId + ", Name: " + this.name);
    }
}
