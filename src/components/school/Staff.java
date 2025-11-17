package components.school;

public class Staff extends Person {
    private String role;

    public Staff(String name, String role) {
        super(name);
        this.role = role;
    }

    public Staff(String id, String name, String role) {
        super(id, name);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String displayDetails() {
        return String.format("Staff - %s, Role: %s", super.displayDetails(), role);
    }
}