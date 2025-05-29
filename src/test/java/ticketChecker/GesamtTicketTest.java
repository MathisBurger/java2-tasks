package ticketChecker;

import de.assignments.ticketChecker.GesamtTicket;
import de.assignments.ticketChecker.Ticket;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class GesamtTicketTest {

    @Test
    public void testClassExtendsTicket() {
        assertTrue(
                "GesamtTicket should extend Ticket", Ticket.class.isAssignableFrom(GesamtTicket.class));
    }

    @Test
    public void testConstructorWithTwoIntParameters() throws NoSuchMethodException {
        Constructor<GesamtTicket> constructor = GesamtTicket.class.getConstructor(int.class, int.class);
        assertNotNull("Constructor with (int, int) parameters should exist", constructor);
        assertTrue("Constructor should be public", Modifier.isPublic(constructor.getModifiers()));
    }

    @Test
    public void testOverridesCanCheckInMethod() throws NoSuchMethodException {
        Method method = GesamtTicket.class.getMethod("canCheckIn", long.class);
        assertEquals("canCheckIn should return boolean", boolean.class, method.getReturnType());
        assertTrue("canCheckIn should be public", Modifier.isPublic(method.getModifiers()));

        // Verify that it is overridden and not just inherited
        boolean isDeclaredInGesamtTicket = method.getDeclaringClass().equals(GesamtTicket.class);
        assertTrue("canCheckIn should be overridden in GesamtTicket", isDeclaredInGesamtTicket);
    }

    @Test
    public void testCanCheckInAlwaysReturnsTrue() {
        GesamtTicket ticket = new GesamtTicket(10, 123);
        assertTrue("canCheckIn should always return true", ticket.canCheckIn(System.currentTimeMillis()));
    }
}
