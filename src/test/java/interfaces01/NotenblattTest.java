package interfaces01;

import de.assignments.interfaces01.Notenblatt;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NotenblattTest {

    @Test
    public void testHasComparableInterface() {
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "WINF");
        assertEquals(true, notenblatt instanceof Comparable);
    }

    @Test
    public void testCompareToNonNotenblatt() {
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "WINF");
        assertEquals(0, notenblatt.compareTo(Integer.valueOf(12)));
    }

    @Test
    public void testCompareToBWL() {
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "WINF");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,3}, "BWL");
        assertEquals(-1, notenblatt.compareTo(notenblatt1));
    }

    @Test
    public void testCompareToBWL2() {
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "WINF");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,3}, "BWL");
        assertEquals(1, notenblatt1.compareTo(notenblatt));
    }

    @Test
    public void testCompareToBetter() {
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "WINF");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,1}, "WINF");
        assertEquals(1, notenblatt.compareTo(notenblatt1));
    }

    @Test
    public void testCompareToWorse() {
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "WINF");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,5}, "WINF");
        assertEquals(-1, notenblatt.compareTo(notenblatt1));
    }

    @Test
    public void testCompareToBetterBWL() {
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "BWL");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,1}, "BWL");
        assertEquals(1, notenblatt.compareTo(notenblatt1));
    }

    @Test
    public void testCompareToWorseBWL() {
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "BWL");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,5}, "BWL");
        assertEquals(-1, notenblatt.compareTo(notenblatt1));
    }

    @Test
    public void testCompareToBetterBWLPrio() {
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "BWL");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,1}, "WINF");
        assertEquals(1, notenblatt.compareTo(notenblatt1));
    }

    @Test
    public void testCompareToWorseBWLPrio() {
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "BWL");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,5}, "WINF");
        assertEquals(1, notenblatt.compareTo(notenblatt1));
    }
}
