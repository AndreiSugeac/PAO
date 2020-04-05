package System;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Services {
    private final DataBase dataBase;

    public Services(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public int addSale(Sales sale) {
        return dataBase.insertSale(sale);
    }

    public Optional<Sales> getSaleByClient(UUID id) {
        return dataBase.getSaleByClientId(id);
    }

    public Optional<Sales> getSaleByTicket(UUID id) {
        return dataBase.getSaleByTicketId(id);
    }

    public List<Sales> getSales() {
        return dataBase.getAllSales();
    }

    public int updateClient(UUID id, Client client) {
        return dataBase.updateClientById(id, client);
    }

    public int updateTicket(UUID id, Ticket ticket) {
        return dataBase.updateTicketById(id, ticket);
    }

    public int deleteByTicket(UUID id) {
        return dataBase.deleteSaleByTicketId(id);
    }

    public int deleteByClient(UUID id) {
        return dataBase.deleteSaleByClientId(id);
    }

    public List<Sales> getAllSalesByEvent(Event event) {
        return dataBase.getAllSalesByEvent(event);
    }

    public int deleteSalesByEvent(Event event) {
        return dataBase.deleteSaleByEvent(event);
    }

}
