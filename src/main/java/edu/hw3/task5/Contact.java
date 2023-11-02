package edu.hw3.task5;

public class Contact {
    private final String name;
    private final String lastname;

    Contact(String name, String lastname) {
        this.lastname = lastname;
        this.name = name;
    }

    Contact(String name) {
        this(name, "");
    }

    public String getLastnameOrName() {
        return lastname.isEmpty() ? name : lastname;
    }

    public String getLastnameAndName() {
        return (this.lastname + " " + this.name).strip();
    }

}
