package Test;

import System.Model.Event;
import System.Model.Ticket;
import System.Model.Client;
import System.Model.Location;
import System.Model.Sales;
import System.Services.Services;
import System.Dao.DataBase;
import System.Model.Person;

import java.util.Arrays;
import java.util.UUID;

public class TestClass {

    public static void main(String[] args) {

       /* Person test = new Person("Sugeac", 23);

        Client[] clients = {new Client("Sugeac Andrei", 20),
                            new Client("John Cena", 45),
                            new Client("Elizabeth Ross", 18)};


        System.out.println("Clientii existenti sunt: " + Arrays.toString(clients));
        Arrays.sort(clients);
        System.out.println("Clientii existenti sortati sunt: " + Arrays.toString(clients));

        Event[] events = {new Event("Nirvana Remastered", "24.08.2023", 20, 180,
                        new Location("Romania", "Bucuresti", "Romexpo")),
                          new Event("Robbie Williams Tour", "01.10.2021", 18, 120,
                        new Location("Australia", "Sydney", "Sydney Opera")),
                          new Event("Pink Floyd Remastered", "30.05.2020", 21, 180,
                        new Location("Germany", "Munich", "Allianz Arena"))};

        System.out.println("Evenimentele existente sunt: " + Arrays.toString(events));

        Ticket[] tickets = new Ticket[events.length];
        for(int i = 0; i < tickets.length; ++i) {
            tickets[i] = new Ticket(UUID.randomUUID(), events[i]);
        }
        System.out.println("Biletele disponibile sunt: " + Arrays.toString(tickets));

        Services service = new Services(new DataBase());
        Sales[] sales = new Sales[tickets.length];
        for(int i = 0; i < sales.length; ++i) {
            sales[i] = new Sales(tickets[i], clients[i]);
            service.addSale(sales[i]);
        }

        System.out.println("All sales made till now: ");
        System.out.println(service.getSales());
        System.out.println("Sale made for " + clients[1].getName() + ": ");
        System.out.println(service.getSaleByClient(clients[1].getId_client()));
        service.deleteByTicket(tickets[0].getTicket_id());
        System.out.println("Updated sales: ");
        System.out.println(service.getSales());
        System.out.println("All sales by event: ");
        System.out.println(service.getAllSalesByEvent(events[1]));*/
    }
}