package ticketChecker;

import de.assignments.ticketChecker.Ticket;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class TicketTest {

    @Test
    public void testClassIsAbstract() {
        assertTrue("Ticket should be abstract",
                Modifier.isAbstract(Ticket.class.getModifiers()));
    }

    @Test
    public void testConstructorWithTwoIntParameters() throws NoSuchMethodException {
        Constructor<Ticket> constructor = Ticket.class.getConstructor(int.class, int.class);
        assertNotNull("Constructor with (int, int) should exist", constructor);
        assertTrue("Constructor should be public",
                Modifier.isPublic(constructor.getModifiers()));
    }

    @Test
    public void testFieldsAreProtected() throws NoSuchFieldException {
        Field preis = Ticket.class.getDeclaredField("preis");
        Field ticketNr = Ticket.class.getDeclaredField("ticketNr");

        assertTrue("Field 'preis' should be protected", Modifier.isProtected(preis.getModifiers()));
        assertTrue("Field 'ticketNr' should be protected", Modifier.isProtected(ticketNr.getModifiers()));
    }

    @Test
    public void testAbstractCanCheckInMethod() throws NoSuchMethodException {
        Method method = Ticket.class.getMethod("canCheckIn", long.class);

        assertEquals("canCheckIn should return boolean", boolean.class, method.getReturnType());
        assertTrue("canCheckIn should be public", Modifier.isPublic(method.getModifiers()));
        assertTrue("canCheckIn should be abstract", Modifier.isAbstract(method.getModifiers()));
    }
}
