package System;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DataBase {

    private static List<Sales> DB = new ArrayList<Sales>();

    public int insertSale(Sales sales) {
        DB.add(new Sales(sales.getTicket(), sales.getClient()));
        return 1;
    }

    public List<Sales> getAllSales() {
        return DB;
    }

    public Optional<Sales> getSaleByClientId(UUID id) {
       return DB.stream()
                .filter(sales -> sales.getClient().getId_client().equals(id))
                .findFirst();
    }

    public Optional<Sales> getSaleByTicketId(UUID id) {
        return DB.stream()
                .filter(sales -> sales.getTicket().getTicket_id().equals(id))
                .findFirst();
    }

    public int updateClientById(UUID id, Client client) {
        return getSaleByClientId(id).map(sale -> {
            int indexOfSaleToUpdate = DB.indexOf(sale);
            if(indexOfSaleToUpdate >= 0) {
                DB.set(indexOfSaleToUpdate, new Sales(sale.getTicket(), client));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    public int updateTicketById(UUID id, Ticket ticket) {
        return getSaleByTicketId(id).map(sale -> {
            int indexOfSaleToUpdate = DB.indexOf(sale);
            if(indexOfSaleToUpdate >= 0) {
                DB.set(indexOfSaleToUpdate, new Sales(ticket, sale.getClient()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    public int deleteSaleByTicketId(UUID id) {
        Optional<Sales> saleToDelete = getSaleByTicketId(id);
        DB.remove(saleToDelete.get());
        return 1;
    }

    public int deleteSaleByClientId(UUID id) {
        Optional<Sales> saleToDelete = getSaleByClientId(id);
        DB.remove(saleToDelete.get());
        return 1;
    }

    public List<Sales> getAllSalesByEvent(Event event) {
        List<Sales> temp = new ArrayList<Sales>();
        for(Sales elem : DB) {
            if(elem.getTicket().getEvent().equals(event))
                temp.add(elem);
        }
        return temp;
    }

    public int deleteSaleByEvent(Event event) {
        List<Sales> salesToDelete = getAllSalesByEvent(event);
        for(Sales sale : salesToDelete) {
            DB.remove(sale);
        }
        return 1;
    }
}
