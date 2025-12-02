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

        // Step 7: Create Courses
        System.out.println("\n--- Creating Courses ---");
        registrationService.createCourse("Advanced Mathematics");
        registrationService.createCourse("Physics 101");
        registrationService.createCourse("Chemistry Basics");

        // Step 8: Display School Directory (all people)
        displaySchoolDirectory(registrationService);

        // Step 9: Mark Attendance using IDs
        System.out.println("\n--- Marking Attendance ---");
        // Assuming student IDs are 1, 2, 3 and course IDs are 101, 102, 103
        attendanceService.markAttendance(1, 101, "Present");
        attendanceService.markAttendance(2, 101, "Absent");
        attendanceService.markAttendance(3, 102, "Present");
        attendanceService.markAttendance(1, 102, "Present");

        // Step 10: Display Attendance Logs
        attendanceService.displayAttendanceLog();

        // Display attendance for a specific student
        Student alice = registrationService.findStudentById(1);
        if (alice != null) {
            attendanceService.displayAttendanceLog(alice);
        }

        // Display attendance for a specific course
        Course mathCourse = registrationService.findCourseById(101);
        if (mathCourse != null) {
            attendanceService.displayAttendanceLog(mathCourse);
        }

        // Step 11: Save all data to files
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