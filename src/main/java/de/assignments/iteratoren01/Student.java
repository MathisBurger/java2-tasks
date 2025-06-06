package de.assignments.iteratoren01;

public class Student {

    private final String firstName;
    private final String lastName;
    private final int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String toString() {
        return firstName + " " + lastName + " " + age;
    }
}
