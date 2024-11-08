package de.assignments.iteratoren01;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Studiengruppe implements Iterable<Student> {

    private List<Student> students;

    public Studiengruppe() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public Iterator<Student> iterator() {
        return this.students.iterator();
    }
}
