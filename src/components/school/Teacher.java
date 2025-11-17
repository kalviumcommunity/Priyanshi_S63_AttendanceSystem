package components.school;

public class Teacher extends Person {
    private String subjectTaught;

    public Teacher(String name, String subjectTaught) {
        super(name);
        this.subjectTaught = subjectTaught;
    }

    public Teacher(String id, String name, String subjectTaught) {
        super(id, name);
        this.subjectTaught = subjectTaught;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    public void setSubjectTaught(String subjectTaught) {
        this.subjectTaught = subjectTaught;
    }

    @Override
    public String displayDetails() {
        return String.format("Teacher - %s, Subject: %s", super.displayDetails(), subjectTaught);
    }
}