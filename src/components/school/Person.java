package components.school;

import java.util.UUID;

public abstract class Person {
    protected final String id;
    protected String name;

    public Person(String name) {
        this.id = generateId();
        this.name = name;
    }

    public Person(String id, String name) {
        this.id = (id == null || id.isEmpty()) ? generateId() : id;
        this.name = name;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String displayDetails() {
        return String.format("ID: %s, Name: %s", id, name);
    }
}