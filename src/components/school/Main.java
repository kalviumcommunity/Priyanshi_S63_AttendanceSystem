package components.school;

import java.util.List;

/**
 * Main entry point demonstrating the use of RegistrationService and AttendanceService
 * with proper dependency injection following the Single Responsibility Principle.
 */
public class Main {
    public static void main(String[] args) {
        // Step 1: Instantiate FileStorageService
        FileStorageService fileStorageService = new FileStorageService();

        // Step 2: Instantiate RegistrationService with FileStorageService dependency
        RegistrationService registrationService = new RegistrationService(fileStorageService);

        // Step 3: Instantiate AttendanceService with both dependencies
        AttendanceService attendanceService = new AttendanceService(fileStorageService, registrationService);

        System.out.println("=== School Management System ===\n");

        // Step 4: Register Students
        System.out.println("--- Registering Students ---");
        registrationService.registerStudent("Alice Johnson", "Grade 10");
        registrationService.registerStudent("Bob Smith", "Grade 11");
        registrationService.registerStudent("Charlie Brown", "Grade 10");

        // Step 5: Register Teachers
        System.out.println("\n--- Registering Teachers ---");
        registrationService.registerTeacher("Dr. Emily White", "Mathematics");
        registrationService.registerTeacher("Prof. John Doe", "Science");

        // Step 6: Register Staff
        System.out.println("\n--- Registering Staff ---");
        registrationService.registerStaff("Mary Johnson", "Librarian");
        registrationService.registerStaff("Robert Lee", "Administrator");

        // Step 7: Create Courses with capacity
        System.out.println("\n--- Creating Courses ---");
        registrationService.createCourse("Advanced Mathematics", 2); // Capacity: 2 students
        registrationService.createCourse("Physics 101", 3);          // Capacity: 3 students
        registrationService.createCourse("Chemistry Basics", 1);     // Capacity: 1 student

        // Step 8: Enroll students in courses
        System.out.println("\n--- Enrolling Students in Courses ---");
        Student alice = registrationService.findStudentById(1);
        Student bob = registrationService.findStudentById(2);
        Student charlie = registrationService.findStudentById(3);
        
        Course mathCourse = registrationService.findCourseById(101);
        Course physicsCourse = registrationService.findCourseById(102);
        Course chemistryCourse = registrationService.findCourseById(103);
        
        // Enroll students in Advanced Mathematics (capacity: 2)
        registrationService.enrollStudentInCourse(alice, mathCourse);
        registrationService.enrollStudentInCourse(bob, mathCourse);
        registrationService.enrollStudentInCourse(charlie, mathCourse); // This should fail - exceeds capacity
        
        // Enroll students in Physics 101 (capacity: 3)
        registrationService.enrollStudentInCourse(alice, physicsCourse);
        registrationService.enrollStudentInCourse(charlie, physicsCourse);
        
        // Enroll student in Chemistry Basics (capacity: 1)
        registrationService.enrollStudentInCourse(bob, chemistryCourse);

        // Step 9: Display course details with enrollment information
        System.out.println("\n--- Course Details with Enrollment ---");
        for (Course course : registrationService.getCourses()) {
            course.displayDetails();
        }

        // Step 10: Display School Directory (all people)
        displaySchoolDirectory(registrationService);

        // Step 11: Mark Attendance using IDs (only for enrolled students)
        System.out.println("\n--- Marking Attendance ---");
        // Check if student is enrolled before marking attendance
        if (mathCourse.getEnrolledStudents().contains(alice)) {
            attendanceService.markAttendance(1, 101, "Present");
        }
        if (mathCourse.getEnrolledStudents().contains(bob)) {
            attendanceService.markAttendance(2, 101, "Absent");
        }
        if (physicsCourse.getEnrolledStudents().contains(charlie)) {
            attendanceService.markAttendance(3, 102, "Present");
        }
        if (physicsCourse.getEnrolledStudents().contains(alice)) {
            attendanceService.markAttendance(1, 102, "Present");
        }

        // Step 12: Display Attendance Logs
        attendanceService.displayAttendanceLog();

        // Display attendance for a specific student
        if (alice != null) {
            attendanceService.displayAttendanceLog(alice);
        }

        // Display attendance for a specific course
        if (mathCourse != null) {
            attendanceService.displayAttendanceLog(mathCourse);
        }

        // Step 13: Save all data to files
        System.out.println("\n--- Saving Data to Files ---");
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\n=== Program Completed Successfully ===");
    }

    /**
     * Displays all people in the school directory (students, teachers, and staff).
     * @param regService The RegistrationService instance
     */
    private static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory (All People) ---");
        List<Person> allPeople = regService.getAllPeople();
        if (allPeople.isEmpty()) {
            System.out.println("No people registered yet.");
            return;
        }
        for (Person person : allPeople) {
            person.displayDetails();
        }
    }
}