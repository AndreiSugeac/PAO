package Interface;

import Backend.System.Dao.DataBase;
import Backend.System.Model.Client;
import Backend.System.Model.Sales;
import Backend.System.Model.Ticket;
import Backend.System.Services.ClientServices;
import Backend.System.Services.EventServices;
import Backend.System.Services.SalesServices;
import Backend.System.Services.TicketServices;

import java.util.Scanner;
import java.util.UUID;

public class Ui {

    private static final ClientServices clientServices = new ClientServices();
    private static final EventServices eventServices = new EventServices();
    private static final SalesServices salesServices = new SalesServices();
    private static final TicketServices ticketServices = new TicketServices();

    private static void open() {
        DataBase.importClients();
        DataBase.importEvents();
        DataBase.importSales();
    }

    public static void main(String[] args) {
        open();
        try {
            boolean status = true; // it means that the app is still running
            while(status) {
                System.out.println("\nSelect your preferred action:\n" +
                                    "0. Exit Program\n" +
                                    "1. Buy a ticket for an event\n" +
                                    "2. See all the events\n");
                System.out.print("Your choice: ");
                Scanner scan = new Scanner(System.in);
                int choice = scan.nextInt();
                switch (choice) {
                    case 0: {
                        status = false;
                        break;
                    }

                    case 1: {
                        System.out.println("Insert your info:");
                        System.out.print("Full Name: ");
                        scan.nextLine();
                        String name = scan.nextLine();
                        System.out.print("Age: ");
                        int age = scan.nextInt();
                        System.out.println("Here are all the available events:");
                        System.out.println(DataBase.getEvents());
                        System.out.println("Select an event from the list by choosing a number from 1 to " + DataBase.getEvents().size());
                        System.out.print("The event you select is: ");
                        int selection = scan.nextInt();
                        if(selection - 1 < 0 || selection - 1 >= DataBase.getEvents().size()) {
                            throw new ArrayIndexOutOfBoundsException("Index " + selection + " for event is out of bounds.");
                        } else {
                            Client currentClient = new Client(name, age);
                            Sales currentSale = new Sales(new Ticket(UUID.randomUUID(), DataBase.getEvents().get(selection - 1)),
                                                            new Client(currentClient.getName(), currentClient.getAge(),
                                                                    currentClient.getId_client()));
                            salesServices.addSale(new Sales(currentSale.getTicket(), currentSale.getClient()));
                            clientServices.insertClient(new Client(currentClient.getName(), currentClient.getAge(),
                                                        currentClient.getId_client()));

                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataBase.getAudit().closeFile();
        }
    }

}
