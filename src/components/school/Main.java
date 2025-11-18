package components.school;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple entry point demonstrating reading students.txt, printing students,
 * and appending a new student. Adjust paths or behavior to match your project.
 */
public class Main {
    public static void main(String[] args) {
        Path studentsFile = Path.of("students.txt");
        List<Student> students = new ArrayList<>();

        try {
            List<String> lines = FileStorageService.readLines(studentsFile);
            for (String line : lines) {
                Student s = Student.fromDataString(line);
                if (s != null) students.add(s);
            }

            System.out.println("Loaded " + students.size() + " students:");
            for (Student s : students) {
                System.out.println(s.displayDetails());
            }

            // Example: append a new student (only if you want to test write path)
            Student newStudent = new Student("Example Student", "R-100");
            FileStorageService.appendData(studentsFile, List.of(newStudent));
            System.out.println("Appended example student: " + newStudent.displayDetails());

        } catch (IOException e) {
            System.err.println("I/O error while accessing " + studentsFile + ": " + e.getMessage());
            e.printStackTrace();
            System.exit(2);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
            System.exit(3);
        }
    }
}