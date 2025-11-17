package components.school;

/**
 * A simple representation of an attendance record.
 * Stored as CSV by FileStorageService where needed.
 */
public class AttendanceRecord implements Storable {
    private final String studentId;
    private final String date; // use yyyy-mm-dd
    private final boolean present;

    public AttendanceRecord(String studentId, String date, boolean present) {
        this.studentId = studentId;
        this.date = date;
        this.present = present;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getDate() {
        return date;
    }

    public boolean isPresent() {
        return present;
    }

    @Override
    public String toDataString() {
        // CSV: studentId,date,present
        return String.join(",", studentId, date, Boolean.toString(present));
    }

    public static AttendanceRecord fromDataString(String line) {
        if (line == null || line.trim().isEmpty()) return null;
        String[] parts = line.split(",", -1);
        String sid = parts.length > 0 ? parts[0] : "";
        String date = parts.length > 1 ? parts[1] : "";
        boolean present = parts.length > 2 && Boolean.parseBoolean(parts[2]);
        return new AttendanceRecord(sid, date, present);
    }
}