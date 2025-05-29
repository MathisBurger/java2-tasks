package ticketChecker;

import de.assignments.ticketChecker.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.*;

import static org.junit.Assert.*;

public class TicketDashboardTest {

    @Test
    public void testFieldIsPrivateListOfTicketCheckers() throws NoSuchFieldException {
        Field field = TicketDashboard.class.getDeclaredField("ticketCheckers");
        assertEquals("Field should be of type List", List.class, field.getType());
        assertTrue("Field 'ticketCheckers' should be private", Modifier.isPrivate(field.getModifiers()));
    }

    @Test
    public void testConstructorWithListParameter() throws NoSuchMethodException {
        Constructor<TicketDashboard> constructor = TicketDashboard.class.getConstructor(List.class);
        assertNotNull("Constructor with List<TicketChecker<Ticket>> should exist", constructor);
        assertTrue("Constructor should be public", Modifier.isPublic(constructor.getModifiers()));
    }

    @Test
    public void testGetStatsOutputCountsCorrectly() {
        // Arrange
        TagesTicket t1 = new TagesTicket(10, 1, 20240529);
        MehrtagesTicket t2 = new MehrtagesTicket(20, 2, 20240528, 20240530);
        GesamtTicket t3 = new GesamtTicket(30, 3);

        Set<Ticket> set1 = new HashSet<>();
        set1.add(t1);
        set1.add(t2);

        Set<Ticket> set2 = new HashSet<>();
        set2.add(t3);

        TicketChecker<Ticket> checker1 = new TicketChecker<>(set1);
        TicketChecker<Ticket> checker2 = new TicketChecker<>(set2);

        List<TicketChecker<Ticket>> list = Arrays.asList(checker1, checker2);
        TicketDashboard dashboard = new TicketDashboard(list);

        // Umleitung der System.out-Ausgabe zum Prüfen
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Act
        dashboard.getStats();

        // Wiederherstellen des Standard-Ausgabestreams
        System.setOut(originalOut);

        // Assert
        String[] lines = outContent.toString().trim().split("\\R");
        assertEquals("There should be exactly 3 lines of output", 3, lines.length);
        assertEquals("Expected 1 TagesTicket", "1", lines[0]);
        assertEquals("Expected 1 MehrtagesTicket", "1", lines[1]);
        assertEquals("Expected 1 GesamtTicket", "1", lines[2]);
    }
}
