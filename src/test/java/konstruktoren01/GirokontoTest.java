package konstruktoren01;

import de.assignments.konstruktoren01.Girokonto;
import org.junit.Test;

import static org.junit.Assert.*;

public class GirokontoTest {

    @Test
    public void testKonstruktorMitKontostandUndUeberziehbar() {
        double initialerKontostand = 200.0;
        boolean ueberziehbar = true;
        Girokonto girokonto = new Girokonto(initialerKontostand, ueberziehbar);

        assertEquals(initialerKontostand, girokonto.getKontostand(), 0.0);
        assertTrue("Das Konto sollte überziehbar sein.", girokonto.isUeberziehbar());
        assertEquals(0.0, girokonto.getDispokredit(), 0.0);
    }

    @Test
    public void testKonstruktorMitKontostandUndDispokredit() {
        double initialerKontostand = 500.0;
        double dispokredit = 1000.0;
        Girokonto girokonto = new Girokonto(initialerKontostand, dispokredit);

        assertEquals(initialerKontostand, girokonto.getKontostand(), 0.0);
        assertTrue("Das Konto sollte überziehbar sein, wenn ein Dispokredit gesetzt ist.", girokonto.isUeberziehbar());
        assertEquals(dispokredit, girokonto.getDispokredit(), 0.0);
    }

    @Test
    public void testStandardKonstruktor() {
        Girokonto girokonto = new Girokonto();
        assertEquals(0.0, girokonto.getKontostand(), 0.0);
        assertFalse("Das Konto sollte nicht überziehbar sein, wenn der Standardkonstruktor verwendet wird.", girokonto.isUeberziehbar());
        assertEquals(0.0, girokonto.getDispokredit(), 0.0);
    }
}
