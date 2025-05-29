package ticketChecker;

import de.assignments.ticketChecker.TagesTicket;
import de.assignments.ticketChecker.Ticket;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class TagesTicketTest {

    @Test
    public void testClassExtendsTicket() {
        assertTrue("TagesTicket should extend Ticket",
                Ticket.class.isAssignableFrom(TagesTicket.class));
    }

    @Test
    public void testConstructorWithThreeIntParameters() throws NoSuchMethodException {
        Constructor<TagesTicket> constructor = TagesTicket.class.getConstructor(
                int.class, int.class, int.class);
        assertNotNull("Constructor with (int, int, int) should exist", constructor);
        assertTrue("Constructor should be public",
                Modifier.isPublic(constructor.getModifiers()));
    }

    @Test
    public void testOverridesCanCheckInMethod() throws NoSuchMethodException {
        Method method = TagesTicket.class.getMethod("canCheckIn", long.class);
        assertEquals("canCheckIn should return boolean", boolean.class, method.getReturnType());
        assertTrue("canCheckIn should be public", Modifier.isPublic(method.getModifiers()));

        boolean isDeclaredInTagesTicket = method.getDeclaringClass().equals(TagesTicket.class);
        assertTrue("canCheckIn should be overridden in TagesTicket", isDeclaredInTagesTicket);
    }

    @Test
    public void testCanCheckInLogic() {
        int gueltigesDatum = 20240529;
        TagesTicket ticket = new TagesTicket(20, 555, gueltigesDatum);

        assertTrue("Matching date should return true", ticket.canCheckIn(20240529));
        assertFalse("Non-matching date should return false", ticket.canCheckIn(20));
    }
}