package interfaces01;

import de.assignments.interfaces01.ArrayIterator;
import de.assignments.interfaces01.Notenblatt;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class ArrayIteratorTest {

    @Test
    public void testArrayIterator() {
        Notenblatt nb1 = new Notenblatt(new int[] {1,2,3}, "WINF");
        Notenblatt nb2 = new Notenblatt(new int[] {1,2,3}, "WINF");
        Notenblatt nb3 = new Notenblatt(new int[] {1,2,3}, "WINF");
        Notenblatt[] array = new Notenblatt[] {nb1, nb2, nb3};

        Iterator iterator = new ArrayIterator(array);
        assertEquals(true, iterator.hasNext());
        assertEquals(true, iterator.next().equals(array[0]));
        assertEquals(true, iterator.hasNext());
        assertEquals(true, iterator.next().equals(array[1]));
        assertEquals(true, iterator.hasNext());
        assertEquals(true, iterator.next().equals(array[2]));
        assertEquals(false, iterator.hasNext());
    }
}
