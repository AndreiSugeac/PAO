package Backend.System.Dao;

import Backend.System.Model.Client;
import Backend.System.Model.Event;
import Backend.System.Model.Sales;

import java.util.List;
import java.util.Optional;

public interface Dao {

    /// POST REQUESTS
    public int insertSale(Sales sales);

    public int addEvent(Event event);

    public int addClient(Client client);

    /// GET REQUESTS
    public List<Sales> getAllSales();

    public Optional<Event> getEventByName(String eventName);

}
