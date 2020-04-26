package Interface;

import System.Dao.DataBase;
import System.Model.Event;
import System.Model.Location;
import System.Services.EventServices;
import System.Services.SalesServices;
import System.Services.TicketServices;

import java.util.Scanner;

public class Admin {
    private static final String User = "admin";
    private static final String password = "pass";
    private static final EventServices eventServices = new EventServices();
    private static final SalesServices salesServices = new SalesServices();
    private static final TicketServices ticketServices = new TicketServices();

    private static void open() {
        DataBase.importEvents();
        DataBase.importSales();
    }

    public static void main(String[] args) {

        open();
        try {
            Scanner scanner = new Scanner(System.in);
            boolean flag = false;
            while (!flag) {
                System.out.print("Enter username: ");
                String user = scanner.nextLine();
                if (user.equals(User)) {
                    System.out.print("Enter password: ");
                    String pass = scanner.nextLine();
                    if (pass.equals(password))
                        flag = true;
                    else System.out.println("Incorrect password");
                } else System.out.println("Incorrect username");
            }
            System.out.println("\n\nWelcome admin\n");
            boolean status = true;
            while (status) {
                System.out.println("\nSelect your preferred action:\n" +
                        "0. Exit Program\n" +
                        "1. Insert Events\n" +
                        "2. Delete an Event\n" +
                        "3. See all the events\n");
                System.out.print("Your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0: {
                        status = false;
                        break;
                    }

                    case 1: {
                        System.out.println("Insert the event info:");
                        System.out.print("Event name: ");
                        scanner.nextLine();
                        String evName = scanner.nextLine();
                        System.out.print("Date of the event: ");
                        String evDate = scanner.nextLine();
                        System.out.print("Starting hour of the event: ");
                        int evHour = scanner.nextInt();
                        System.out.print("Duration of the event: ");
                        int duration = scanner.nextInt();
                        System.out.print("Country: ");
                        scanner.nextLine();
                        String country = scanner.nextLine();
                        System.out.print("City: ");
                        String city = scanner.nextLine();
                        System.out.print("Venue: ");
                        String venue = scanner.nextLine();

                        eventServices.insertEvent(new Event(evName, evDate, evHour, duration, new Location(country, city, venue)));

                        break;
                    }

                    case 2:{
                        System.out.println("Warning!!!");
                        System.out.println("By deleting an event from the database you will delete all the sales made for the" +
                                "respective event");
                        System.out.println("Do you wish to proceed?");
                        System.out.println("Options: " + "1.Yes, " + "2.No");
                        System.out.print("Your selection: ");
                        int answer = scanner.nextInt();
                        if(answer == 2)
                            break;
                        System.out.println("Here are all the available events:");
                        System.out.println(DataBase.getEvents());
                        System.out.println("Select an event from the list by choosing a number from 1 to " + DataBase.getEvents().size());
                        System.out.print("The event you select is: ");
                        scanner.nextLine();
                        String selection = scanner.nextLine();
                        salesServices.deleteSalesByEvent(eventServices.getEventByName(selection));
                        eventServices.deleteEventByName(selection);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
