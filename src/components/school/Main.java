package components.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        // Create students (Part-05 refactor with Person hierarchy)
        Student student1 = new Student("Alice Wonderland", "10th Grade");
        Student student2 = new Student("Bob The Builder", "11th Grade");
        
        // Create teachers and staff (Part-05 additions)
        Teacher teacher1 = new Teacher("Dr. Smith", "Mathematics");
        Staff staff1 = new Staff("John Doe", "Librarian");
        
        // Create courses
        Course course1 = new Course("Intro to Programming");
        Course course2 = new Course("Data Structures");

        System.out.println("\nRegistered Students:");
        student1.displayDetails();
        student2.displayDetails();
        
        System.out.println("\nTeaching Staff:");
        teacher1.displayDetails();
        
        System.out.println("\nNon-Teaching Staff:");
        staff1.displayDetails();

        System.out.println("\nAvailable Courses:");
        course1.displayDetails();
        course2.displayDetails();

        // --- Attendance Recording ---
        System.out.println("\n--- Attendance Recording ---");
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Record valid attendance (using objects now, not IDs)
        AttendanceRecord record1 = new AttendanceRecord(student1, course1, "Present");
        attendanceLog.add(record1);

        // Attempt to record invalid attendance status
        AttendanceRecord record2 = new AttendanceRecord(student2, course1, "Late");
        attendanceLog.add(record2); // Will be stored as "Invalid"

        // Record another valid attendance
        AttendanceRecord record3 = new AttendanceRecord(student2, course2, "Absent");
        attendanceLog.add(record3);

        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
        
        // Demonstrate FileStorageService (Part-05 feature)
        System.out.println("\n--- File Storage Demo ---");
        FileStorageService storage = new FileStorageService();
        
        List<Student> students = List.of(student1, student2);
        storage.saveData(students, "students.txt");
        
        List<Course> courses = List.of(course1, course2);
        storage.saveData(courses, "courses.txt");
        
        storage.saveData(attendanceLog, "attendancelog.txt");

        System.out.println("\nMerged Part-05 refactor with Setup enhancements complete.");
    }
}