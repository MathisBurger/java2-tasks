package konstruktoren01;

import de.assignments.konstruktoren01.Girokonto;
import de.assignments.konstruktoren01.Kontoanzeige;
import de.assignments.konstruktoren01.Tagesgeldkonto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KontoanzeigeTest {

    @Test
    public void test() {
        Kontoanzeige k = new Kontoanzeige(new Girokonto(), new Tagesgeldkonto());
        assertEquals(k.getKonten().length, 2);
        assertTrue(k.getKonten()[0] instanceof Girokonto);
        assertTrue(k.getKonten()[1] instanceof Tagesgeldkonto);
    }
}
