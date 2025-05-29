package ticketChecker;

import de.assignments.ticketChecker.GesamtTicket;
import de.assignments.ticketChecker.Ticket;
import de.assignments.ticketChecker.TicketChecker;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.*;

import static org.junit.Assert.*;

public class TicketCheckerTest {

    @Test
    public void testIsGenericWithTicketBound() {
        TypeVariable<?>[] typeParams = TicketChecker.class.getTypeParameters();
        assertEquals("There should be one generic type parameter", 1, typeParams.length);

        TypeVariable<?> t = typeParams[0];
        Type[] bounds = t.getBounds();

        assertEquals("Generic type T should extend Ticket", Ticket.class, bounds[0]);
    }

    @Test
    public void testImplementsIterable() {
        boolean implementsIterable = false;
        for (Type iface : TicketChecker.class.getGenericInterfaces()) {
            if (iface instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType) iface;
                if (pt.getRawType() == Iterable.class) {
                    implementsIterable = true;
                    break;
                }
            }
        }
        assertTrue("TicketChecker should implement Iterable<T>", implementsIterable);
    }

    @Test
    public void testConstructorWithSetParameter() throws NoSuchMethodException {
        Constructor<TicketChecker> constructor = TicketChecker.class.getConstructor(Set.class);
        assertNotNull("Constructor with Set<T> parameter should exist", constructor);
        assertTrue("Constructor should be public", Modifier.isPublic(constructor.getModifiers()));
    }

    @Test
    public void testCheckTicketLogic() {
        Ticket ticket1 = new GesamtTicket(10, 1);
        Ticket ticket2 = new GesamtTicket(12, 2);

        Set<Ticket> ticketSet = new HashSet<>();
        ticketSet.add(ticket1);

        TicketChecker<Ticket> checker = new TicketChecker<>(ticketSet);

        assertTrue("Ticket in set and valid should return true",
                checker.checkTicket(ticket1, System.currentTimeMillis()));
        assertFalse("Ticket not in set should return false",
                checker.checkTicket(ticket2, System.currentTimeMillis()));
    }

    @Test
    public void testIteratorReturnsCorrectValues() {
        Ticket t1 = new GesamtTicket(5, 10);
        Ticket t2 = new GesamtTicket(6, 11);

        Set<Ticket> ticketSet = new HashSet<>();
        ticketSet.add(t1);
        ticketSet.add(t2);

        TicketChecker<Ticket> checker = new TicketChecker<>(ticketSet);
        Iterator<Ticket> it = checker.iterator();

        Set<Ticket> iterated = new HashSet<>();
        while (it.hasNext()) {
            iterated.add(it.next());
        }

        assertEquals("Iterator should return all tickets", ticketSet, iterated);
    }
}
