package components.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;
    private List<Course> courses;
    private FileStorageService storageService;
    
    // File names for persistence
    private final String STUDENTS_FILE = "students.txt";
    private final String TEACHERS_FILE = "teachers.txt";
    private final String STAFF_FILE = "staff.txt";
    private final String COURSES_FILE = "courses.txt";

    public RegistrationService(FileStorageService storageService) {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.storageService = storageService;
    }

    // Register a student
    public void registerStudent(String name, String gradeLevel) {
        Student student = new Student(name, gradeLevel);
        students.add(student);
        System.out.println("Registered student: " + name + " with ID: " + student.getId());
    }

    // Register a teacher
    public void registerTeacher(String name, String subjectTaught) {
        Teacher teacher = new Teacher(name, subjectTaught);
        teachers.add(teacher);
        System.out.println("Registered teacher: " + name + " with ID: " + teacher.getId());
    }

    // Register a staff member
    public void registerStaff(String name, String role) {
        Staff staff = new Staff(name, role);
        staffMembers.add(staff);
        System.out.println("Registered staff: " + name + " with ID: " + staff.getId());
    }

    // Create a course
    public void createCourse(String courseName) {
        Course course = new Course(courseName);
        courses.add(course);
        System.out.println("Created course: " + courseName + " with ID: C" + course.getCourseId());
    }

    // Getters for lists
    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    // Find student by ID
    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Find course by ID
    public Course findCourseById(int id) {
        for (Course course : courses) {
            if (course.getCourseId() == id) {
                return course;
            }
        }
        return null;
    }

    // Get all people (students, teachers, and staff combined)
    public List<Person> getAllPeople() {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(students);
        allPeople.addAll(teachers);
        allPeople.addAll(staffMembers);
        return allPeople;
    }

    // Save all registrations to their respective files
    public void saveAllRegistrations() {
        storageService.saveData(students, STUDENTS_FILE);
        storageService.saveData(teachers, TEACHERS_FILE);
        storageService.saveData(staffMembers, STAFF_FILE);
        storageService.saveData(courses, COURSES_FILE);
    }
}
