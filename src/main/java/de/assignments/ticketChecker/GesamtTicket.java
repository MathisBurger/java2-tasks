package de.assignments.ticketChecker;

public class GesamtTicket extends Ticket {

    public GesamtTicket(int preis, int ticketNr) {
        super(preis, ticketNr);
    }

    @Override
    public boolean canCheckIn(long datum) {
        return true;
    }
}
