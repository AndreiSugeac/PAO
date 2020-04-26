package Test;

import System.Dao.DataBase;
import System.Model.*;
import System.Services.ClientServices;
import System.Services.EventServices;
import System.Services.SalesServices;
import System.Services.TicketServices;

import java.util.UUID;

public class TestCSV {
    public static void main(String[] args) {
        /*Ticket testTicket = new Ticket(UUID.randomUUID(), new Event("Nirvana Remastered", "24.08.2023",
                                    20, 180, new Location("Romania", "Bucuresti", "Romexpo")));


        DataBase.importEvents();
        SalesServices testSales = new SalesServices();

        Client testClient = new Client("Andrei Sugeac", 20);
        testSales.addSale(new Sales(testTicket, testClient));
        System.out.println(testSales.getAllSalesByEvent(DataBase.getEvents().get(0)));
        DataBase.importEvents();
        //DataBase.importClients();
        DataBase.importSales();

        Ticket testTicket = new Ticket(UUID.randomUUID(), new Event("Robbie Williams", "24.08.2023",
                20, 180, new Location("Romania", "Bucuresti", "Romexpo")));
        Client testClient = new Client("Andrei Sugeac", 20);
        Event ev = new Event("Pink Floyd Remastered","30.05.2020",21,180,
                new Location("Germany","Munich","Allianz Arena"));
        
        SalesServices testSales = new SalesServices();
        testSales.addSale(new Sales(testTicket, testClient));
        testSales.deleteSalesByEvent(DataBase.getEvents().get(0));*/
        /*EventServices testEv = new EventServices();
        testEv.insertEvent(ev);

        DataBase.importClients();
        ClientServices testClients = new ClientServices();
        testClients.insertClient(testClient);*/
    }
}
