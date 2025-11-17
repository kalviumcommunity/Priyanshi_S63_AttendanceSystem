package components.school;

public class Student extends Person implements Storable {

    private String gradeLevel;

    // Constructor compatible with existing code (default grade level)
    public Student(String name) {
        this(name, "Not Specified");
    }

    // Constructor with grade level
    public Student(String name, String gradeLevel) {
        super(name);
        this.gradeLevel = gradeLevel;
    }

    // Getter for gradeLevel
    public String getGradeLevel() {
        return gradeLevel;
    }

    // Compatibility method for Setup code
    public int getStudentId() {
        return getId();
    }

    @Override
    public void displayDetails() {
        System.out.print("Student ID: " + getId() + ", Name: " + getName());
        if (!"Not Specified".equals(gradeLevel)) {
            System.out.print(", Grade Level: " + gradeLevel);
        }
        System.out.println();
    }

    @Override
    public String toDataString() {
        return getId() + "," + getName() + "," + gradeLevel;
    }

    // Static method to create Student from data string
    public static Student fromDataString(String data) {
        String[] parts = data.split(",");
        if (parts.length >= 2) {
            String name = parts[1];
            String gradeLevel = parts.length > 2 ? parts[2] : "Not Specified";
            return new Student(name, gradeLevel);
        }
        throw new IllegalArgumentException("Invalid student data: " + data);
    }
}
