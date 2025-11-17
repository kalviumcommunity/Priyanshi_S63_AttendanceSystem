package components.school;

public class Student extends Person implements Storable { // Extends Person

    private String gradeLevel; // Student-specific field

    // Constructor compatible with existing code (no gradeLevel)
    public Student(String name) {
        super(name); // Calls Person constructor
        this.gradeLevel = "N/A"; // Default grade level
    }

    // Constructor with gradeLevel
    public Student(String name, String gradeLevel) {
        super(name); // Calls Person constructor
        this.gradeLevel = gradeLevel;
    }

    // Getter for gradeLevel
    public String getGradeLevel() {
        return gradeLevel;
    }

    // For backward compatibility with code expecting getStudentId()
    public int getStudentId() {
        return getId();
    }

    @Override // Good practice to indicate overriding
    public void displayDetails() {
        System.out.println("Student ID: " + getId() + ", Name: " + getName());
        // Only show grade level if it's not the default
        if (!gradeLevel.equals("N/A")) {
            System.out.println(", Grade Level: " + gradeLevel + " (Role: Student)");
        }
    }

    @Override
    public String toDataString() {
        // Format: id,name,gradeLevel
        return getId() + "," + getName() + "," + gradeLevel;
    }
}
