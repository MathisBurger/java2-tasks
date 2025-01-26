package comparable01;

import de.assignments.comparable01.Notenblatt;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NotenblattTest {

    @Test
    public void testAvgCalculation() {
        Notenblatt notenblatt = new Notenblatt(
                Arrays.asList(1f, 2f, 3f, 4f, 5f)
        );
        assertEquals(3f, (float)notenblatt.getDurchschnitt(), 0.0f);
    }

    @Test
    public void testCompareSort() {
        Notenblatt nb1 = new Notenblatt(
                Arrays.asList(1f, 2f, 3f, 4f, 5f)
        );
        Notenblatt nb2 = new Notenblatt(
                Arrays.asList(2f, 4f, 6f, 8f, 10f)
        );
        assertEquals(-1, nb1.compareTo(nb2));
        assertEquals(1, nb2.compareTo(nb1));
        assertEquals(0, nb1.compareTo(nb1));
    }
}
