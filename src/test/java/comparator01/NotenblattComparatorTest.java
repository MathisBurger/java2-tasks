package comparator01;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NotenblattComparatorTest {

    @Test
    public void testNotenblattComparator() {
        NotenblattComparator comparator = new NotenblattComparator();
        Notenblatt nb1 = new Notenblatt(
                Arrays.asList(1f, 2f, 3f, 4f, 5f)
        );
        Notenblatt nb2 = new Notenblatt(
                Arrays.asList(2f, 4f, 6f, 8f, 10f)
        );
        assertEquals(-1, comparator.compare(nb1, nb2));
        assertEquals(1, comparator.compare(nb2, nb1));
        assertEquals(0, comparator.compare(nb1, nb1));
        assertEquals(-1, comparator.compare(null, nb1));
        assertEquals(-1, comparator.compare(null, nb2));
        assertEquals(1, comparator.compare(nb1, null));
        assertEquals(0, comparator.compare(null, null));
    }
}
