package System;

import java.util.List;

public class Sales {

    private Ticket ticket;
    private Client client;

    public Sales(Ticket ticket, Client client) {
        this.ticket = new Ticket(ticket.getTicket_id(), ticket.getEvent());
        this.client = new Client(client.getName(), client.getAge(), client.getId_client());
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "\nSales{" +
                ticket.toString() + " ," +
                client.toString() +
                "}";
    }
}
