package konstruktoren01;

import de.assignments.konstruktoren01.Tagesgeldkonto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TagesgeldkontoTest {

    @Test
    public void testKonstruktorMitZinssatz() {
        double zinssatz = 1.5;
        Tagesgeldkonto tagesgeldkonto = new Tagesgeldkonto(zinssatz);

        assertEquals(0.0, tagesgeldkonto.getKontostand(), 0.0);
        assertEquals(zinssatz, tagesgeldkonto.getZinssatz(), 0.0);
    }

    @Test
    public void testStandardKonstruktor() {
        Tagesgeldkonto tagesgeldkonto = new Tagesgeldkonto();

        assertEquals(0.0, tagesgeldkonto.getKontostand(), 0.0);
        assertEquals(0.0, tagesgeldkonto.getZinssatz(), 0.0);
    }

    @Test
    public void testKonstruktorMitKontostandUndZinssatz() {
        double kontostand = 1000.0;
        double zinssatz = 2.0;
        Tagesgeldkonto tagesgeldkonto = new Tagesgeldkonto(kontostand, zinssatz);

        assertEquals(kontostand, tagesgeldkonto.getKontostand(), 0.0);
        assertEquals(zinssatz, tagesgeldkonto.getZinssatz(), 0.0);
    }
}