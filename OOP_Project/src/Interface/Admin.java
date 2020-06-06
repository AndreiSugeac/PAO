/*package Interface;

import Backend.System.Dao.DataBase;
import Backend.System.Model.Event;
import Backend.System.Model.Location;
import Backend.System.Services.EventServices;
import Backend.System.Services.SalesServices;
import Backend.System.Services.TicketServices;

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
            Scanner scanner = new Scanner(Backend.System.in);
            boolean flag = false;
            while (!flag) {
                Backend.System.out.print("Enter username: ");
                String user = scanner.nextLine();
                if (user.equals(User)) {
                    Backend.System.out.print("Enter password: ");
                    String pass = scanner.nextLine();
                    if (pass.equals(password))
                        flag = true;
                    else Backend.System.out.println("Incorrect password");
                } else Backend.System.out.println("Incorrect username");
            }
            Backend.System.out.println("\n\nWelcome admin\n");
            boolean status = true;
            while (status) {
                Backend.System.out.println("\nSelect your preferred action:\n" +
                        "0. Exit Program\n" +
                        "1. Insert Events\n" +
                        "2. Delete an Event\n" +
                        "3. See all the events\n");
                Backend.System.out.print("Your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0: {
                        status = false;
                        break;
                    }

                    case 1: {
                        Backend.System.out.println("Insert the event info:");
                        Backend.System.out.print("Event name: ");
                        scanner.nextLine();
                        String evName = scanner.nextLine();
                        Backend.System.out.print("Date of the event: ");
                        String evDate = scanner.nextLine();
                        Backend.System.out.print("Starting hour of the event: ");
                        int evHour = scanner.nextInt();
                        Backend.System.out.print("Duration of the event: ");
                        int duration = scanner.nextInt();
                        Backend.System.out.print("Country: ");
                        scanner.nextLine();
                        String country = scanner.nextLine();
                        Backend.System.out.print("City: ");
                        String city = scanner.nextLine();
                        Backend.System.out.print("Venue: ");
                        String venue = scanner.nextLine();

                        eventServices.insertEvent(new Event(evName, evDate, evHour, new Location(country, city, venue)));

                        break;
                    }

                    case 2:{
                        Backend.System.out.println("Warning!!!");
                        Backend.System.out.println("By deleting an event from the database you will delete all the sales made for the" +
                                "respective event");
                        Backend.System.out.println("Do you wish to proceed?");
                        Backend.System.out.println("Options: " + "1.Yes, " + "2.No");
                        Backend.System.out.print("Your selection: ");
                        int answer = scanner.nextInt();
                        if(answer == 2)
                            break;
                        Backend.System.out.println("Here are all the available events:");
                        Backend.System.out.println(DataBase.getEvents());
                        Backend.System.out.println("Select an event from the list by choosing a number from 1 to " + DataBase.getEvents().size());
                        Backend.System.out.print("The event you select is: ");
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
*/