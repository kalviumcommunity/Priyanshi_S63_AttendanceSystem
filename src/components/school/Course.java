package components.school;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;

    private int courseId;       // Made private
    private String courseName;  // Made private

    // Constructor
    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++; // Auto-increment and assign ID
        this.courseName = courseName;          // Assign course name
    }

    // Getter for courseId
    public int getCourseId() {
        return courseId;
    }

    // Getter for courseName
    public String getCourseName() {
        return courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID: C" + this.courseId + ", Name: " + this.courseName);
    }

    @Override
    public String toDataString() {
        return courseId + "," + courseName;
    }

    // Static method to create Course from data string
    public static Course fromDataString(String data) {
        String[] parts = data.split(",");
        if (parts.length >= 2) {
            // Note: We can't restore the exact ID since it's auto-generated
            // For proper restoration, we'd need to adjust the counter or handle this differently
            return new Course(parts[1]);
        }
        throw new IllegalArgumentException("Invalid course data: " + data);
    }
}