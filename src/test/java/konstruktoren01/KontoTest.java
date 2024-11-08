package konstruktoren01;

import de.assignments.konstruktoren01.Konto;
import org.junit.Test;

import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KontoTest {

    // Testklasse zum Testen des abstrakten Konto-Verhaltens
    static class TestKonto extends Konto {
        public TestKonto(double kontostand) {
            super(kontostand);
        }

        public TestKonto() {
            super();
        }
    }

    @Test
    public void testIsAbstract() {
        assertTrue("The class Konto should be abstract.", Modifier.isAbstract(Konto.class.getModifiers()));
    }

    @Test
    public void testKonstruktorMitParameter() {
        double initialerKontostand = 100.0;
        Konto konto = new TestKonto(initialerKontostand);
        assertEquals(initialerKontostand, konto.getKontostand(), 0.0);
    }

    @Test
    public void testStandardKonstruktor() {
        Konto konto = new TestKonto();
        assertEquals( 0.0, konto.getKontostand(), 0.0);
    }
}