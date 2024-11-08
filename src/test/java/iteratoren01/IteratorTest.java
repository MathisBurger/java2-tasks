package iteratoren01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IteratorTest {

    @Test
    public void testIterator() {
        Studiengruppe gruppe = new Studiengruppe();
        gruppe.addStudent(new Student("Hans", "Wurst", 19));
        for (Student student : gruppe) {
            assertEquals("Hans Wurst 19", student.toString());
        }
        assertEquals(gruppe.iterator().next().toString(), "Hans Wurst 19");
    }
}
