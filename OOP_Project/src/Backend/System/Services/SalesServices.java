package Backend.System.Services;

import Backend.System.Model.Event;
import Backend.System.Model.Sales;

import java.util.List;
import java.util.UUID;

public class SalesServices extends Services {

    public int addSale(Sales sale) {
        return getPostgres().insertSale(sale);
    }

    public Sales getSaleByClient(UUID id) {
        return getDataBase().getSaleByClientId(id).get();
    }

    public Sales getSaleByTicket(UUID id) {
        return getDataBase().getSaleByTicketId(id).get();
    }

    public List<Sales> getSales() {
        return getDataBase().getAllSales();
    }

    public List<Sales> getAllSalesByEvent(Event event) {
        return getDataBase().getAllSalesByEvent(event);
    }

    public int deleteSalesByEvent(Event event) {
        return getDataBase().deleteSaleByEvent(event);
    }

    public int deleteByTicket(UUID id) {
        return getDataBase().deleteSaleByTicketId(id);
    }

}
