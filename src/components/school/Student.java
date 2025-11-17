package components.school;

public class Student extends Person implements Storable {
    private final String rollNumber;
    private String studentClass; // optional

    public Student(String name, String rollNumber) {
        super(name);
        this.rollNumber = rollNumber;
    }

    public Student(String id, String name, String rollNumber, String studentClass) {
        super(id, name);
        this.rollNumber = rollNumber;
        this.studentClass = studentClass;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String displayDetails() {
        return String.format("Student - %s, Roll: %s, Class: %s", super.displayDetails(), rollNumber, studentClass);
    }

    @Override
    public String toDataString() {
        // CSV: id,name,rollNumber,studentClass
        String safeName = (getName() == null) ? "" : getName().replace(",", " ");
        String safeClass = (studentClass == null) ? "" : studentClass.replace(",", " ");
        return String.join(",", getId(), safeName, rollNumber, safeClass);
    }

    /**
     * Helper to construct Student from a CSV line produced by toDataString.
     * Expected format: id,name,rollNumber,studentClass
     */
    public static Student fromDataString(String line) {
        if (line == null || line.trim().isEmpty()) return null;
        String[] parts = line.split(",", -1);
        String id = parts.length > 0 ? parts[0] : "";
        String name = parts.length > 1 ? parts[1] : "";
        String roll = parts.length > 2 ? parts[2] : "";
        String cls = parts.length > 3 ? parts[3] : "";
        return new Student(id, name, roll, cls);
    }
}