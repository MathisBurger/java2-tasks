package ticketChecker;

import de.assignments.ticketChecker.MehrtagesTicket;
import de.assignments.ticketChecker.Ticket;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class MehrtagesTicketTest {

    @Test
    public void testClassExtendsTicket() {
        assertTrue("MehrtagesTicket should extend Ticket",
                Ticket.class.isAssignableFrom(MehrtagesTicket.class));
    }

    @Test
    public void testConstructorWithFourIntParameters() throws NoSuchMethodException {
        Constructor<MehrtagesTicket> constructor = MehrtagesTicket.class.getConstructor(
                int.class, int.class, int.class, int.class);
        assertNotNull("Constructor with (int, int, int, int) should exist", constructor);
        assertTrue("Constructor should be public",
                Modifier.isPublic(constructor.getModifiers()));
    }

    @Test
    public void testOverridesCanCheckInMethod() throws NoSuchMethodException {
        Method method = MehrtagesTicket.class.getMethod("canCheckIn", long.class);
        assertEquals("canCheckIn should return boolean", boolean.class, method.getReturnType());
        assertTrue("canCheckIn should be public", Modifier.isPublic(method.getModifiers()));

        boolean isDeclaredInMehrtagesTicket = method.getDeclaringClass().equals(MehrtagesTicket.class);
        assertTrue("canCheckIn should be overridden in MehrtagesTicket", isDeclaredInMehrtagesTicket);
    }

    @Test
    public void testCanCheckInLogic() {
        int start = 20240101;
        int end = 20240105;
        MehrtagesTicket ticket = new MehrtagesTicket(15, 101, start, end);

        assertTrue("Date within range should return true", ticket.canCheckIn(20240103));
        assertTrue("Start date should return true", ticket.canCheckIn(20240101));
        assertTrue("End date should return true", ticket.canCheckIn(20240105));
        assertFalse("Date before start should return false", ticket.canCheckIn(20231231));
        assertFalse("Date after end should return false", ticket.canCheckIn(20240106));
    }
}

