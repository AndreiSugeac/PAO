package System;

import java.util.UUID;

public class Ticket {

    private UUID ticket_id;
    private Event event;

    public Ticket(UUID ticket_id, Event event) {
        this.ticket_id = ticket_id;
        this.event = new Event(event.getNameEvent(),event.getDate(), event.getStartingHour(), event.getDuration(), event.getLocation());
    }

    public UUID getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(UUID ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket_id=" + ticket_id +
                ", " + event +
                '}';
    }
}
