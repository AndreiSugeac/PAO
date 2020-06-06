package Backend.System.Services;

import Backend.System.Model.Ticket;

import java.util.UUID;

public class TicketServices extends Services {

    public int updateTicket(UUID id, Ticket ticket) {
        return getDataBase().updateTicketById(id, ticket);
    }

}
