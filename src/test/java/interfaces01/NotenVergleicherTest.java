package interfaces01;

import de.assignments.interfaces01.NotenVergleicher;
import de.assignments.interfaces01.Notenblatt;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class NotenVergleicherTest {

    @Test
    public void testHasComparatorInterface() {
        NotenVergleicher notenVergleicher = new NotenVergleicher();
        assertEquals(true, notenVergleicher instanceof Comparator);
    }

    @Test
    public void testCompareToBWL() {
        NotenVergleicher notenVergleicher = new NotenVergleicher();
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "WINF");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,3}, "BWL");
        assertEquals(-1, notenVergleicher.compare(notenblatt, notenblatt1));
    }

    @Test
    public void testCompareToBWL2() {
        NotenVergleicher notenVergleicher = new NotenVergleicher();
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "WINF");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,3}, "BWL");
        assertEquals(1, notenVergleicher.compare(notenblatt1, notenblatt));
    }

    @Test
    public void testCompareToBetter() {
        NotenVergleicher notenVergleicher = new NotenVergleicher();
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "WINF");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,1}, "WINF");
        assertEquals(1, notenVergleicher.compare(notenblatt, notenblatt1));
    }

    @Test
    public void testCompareToWorse() {
        NotenVergleicher notenVergleicher = new NotenVergleicher();
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "WINF");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,5}, "WINF");
        assertEquals(-1, notenVergleicher.compare(notenblatt, notenblatt1));
    }

    @Test
    public void testCompareToBetterBWL() {
        NotenVergleicher notenVergleicher = new NotenVergleicher();
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "BWL");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,1}, "BWL");
        assertEquals(1, notenVergleicher.compare(notenblatt, notenblatt1));
    }

    @Test
    public void testCompareToWorseBWL() {
        NotenVergleicher notenVergleicher = new NotenVergleicher();
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "BWL");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,5}, "BWL");
        assertEquals(-1, notenVergleicher.compare(notenblatt, notenblatt1));
    }

    @Test
    public void testCompareToBetterBWLPrio() {
        NotenVergleicher notenVergleicher = new NotenVergleicher();
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "BWL");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,1}, "WINF");
        assertEquals(1, notenVergleicher.compare(notenblatt, notenblatt1));
    }

    @Test
    public void testCompareToWorseBWLPrio() {
        NotenVergleicher notenVergleicher = new NotenVergleicher();
        Notenblatt notenblatt = new Notenblatt(new int[] {1,2,3}, "BWL");
        Notenblatt notenblatt1 = new Notenblatt(new int[] {1,2,5}, "WINF");
        assertEquals(1, notenVergleicher.compare(notenblatt, notenblatt1));
    }
}
