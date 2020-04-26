package System.Dao;

import CsvFile.Audit;
import CsvFile.CsvReader;
import CsvFile.CsvWriter;
import System.Model.*;

import java.util.*;

public class DataBase {

    private static String csvClient = "Client.csv";
    private static String csvEvent = "Event.csv";
    private static String csvSale = "Sales.csv";
    private static final Audit audit = new Audit();

    private static List<Sales> DB = new ArrayList<Sales>();
    private static List<Event> events = new ArrayList<Event>();
    private static List<Client> clients = new ArrayList<Client>();

    public static void importSales() {
        CsvReader csvReader = new CsvReader(csvSale);
        csvReader.readCSV();
        for(String[] line: csvReader.getData()) {
            if(line.length != 0) {
                DB.add(new Sales(new Ticket(UUID.fromString(line[0].toString()), new Event(line[1], line[2], Integer.parseInt(line[3]),
                        Integer.parseInt(line[4]), new Location(line[5], line[6], line[7]))), new Client(line[8], Integer.parseInt(line[9]),
                        UUID.fromString(line[10].toString()))));
            }
        }
    }

    public static void importEvents() {
        CsvReader csvReader = new CsvReader(csvEvent);
        csvReader.readCSV();
        for(String[] line: csvReader.getData()) {
            if(line.length != 0) {
                events.add(new Event(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]),
                        new Location(line[4], line[5], line[6])));
            }
        }
    }

    public static void importClients() {
        CsvReader csvReader = new CsvReader(csvClient);
        csvReader.readCSV();
        for(String[] line: csvReader.getData()) {
            if(line.length != 0) {
                clients.add(new Client(line[0], Integer.parseInt(line[1]), UUID.fromString(line[2].toString())));
            }
        }
    }

    public static void saveSales() {
        CsvWriter csvWriter = new CsvWriter(csvSale);
        for(Sales temp: DB) {
            csvWriter.writeToCsv(temp.toStringCsv());
        }
        csvWriter.closeFile();
    }

    public static void saveEvents() {
        CsvWriter csvWriter = new CsvWriter(csvEvent);
        for(Event temp: events) {
            csvWriter.writeToCsv(temp.toStringCsv());
            csvWriter.writeToCsv("\n");
        }
        csvWriter.closeFile();
    }

    public static void saveClients() {
        CsvWriter csvWriter = new CsvWriter(csvClient);
        for(Client temp: clients) {
            csvWriter.writeToCsv(temp.toStringCsv());
            csvWriter.writeToCsv("\n");
        }
        csvWriter.closeFile();
    }

    public static List<Sales> getDB() {
        return DB;
    }

    public static List<Event> getEvents() {
        return events;
    }

    public static List<Client> getClients() {
        return clients;
    }

    public static Audit getAudit() {
        return audit;
    }

    // POST REQUESTS
    public int insertSale(Sales sales) {
        DB.add(new Sales(sales.getTicket(), sales.getClient()));
        saveSales();
        audit.insertAction(sales.toString(), csvSale);
        return 1;
    }

    public int addEvent(Event event) {
        events.add(new Event(event.getNameEvent(), event.getDate(), event.getStartingHour(), event.getDuration(), event.getLocation()));
        saveEvents();
        audit.insertAction(event.toString(), csvEvent);
        return 1;
    }

    public int addClient(Client client) {
        clients.add(new Client(client.getName(), client.getAge(), client.getId_client()));
        saveClients();
        audit.insertAction(client.toString(), csvClient);
        return 1;
    }

    // GET REQUESTS
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

    public List<Sales> getAllSalesByEvent(Event event) {
        List<Sales> temp = new ArrayList<Sales>();
        for(Sales elem : DB) {
            if(elem.getTicket().getEvent().equals(event))
                temp.add(elem);
        }
        return temp;
    }

    public Optional<Event> getEventByName(String eventName) {
        return events.stream()
                    .filter(event -> event.getNameEvent().equals(eventName))
                    .findAny();
    }

    // PUT REQUESTS
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

    // DELETE REQUESTS
    public int deleteSaleByTicketId(UUID id) {
        Optional<Sales> saleToDelete = getSaleByTicketId(id);
        DB.remove(saleToDelete.get());
        saveSales();
        audit.deleteAction(saleToDelete.toString(), csvSale);
        return 1;
    }

    public int deleteSaleByClientId(UUID id) {
        Optional<Sales> saleToDelete = getSaleByClientId(id);
        DB.remove(saleToDelete.get());
        saveClients();
        audit.deleteAction(saleToDelete.toString(), csvSale);
        return 1;
    }

    public int deleteEventByName(String eventName) {
        Optional<Event> eventToDelete = getEventByName(eventName);
        events.remove(eventToDelete.get());
        saveEvents();
        audit.deleteAction(eventToDelete.get().toString(), csvEvent);
        return 1;
    }

    public int deleteSaleByEvent(Event event) {
        List<Sales> salesToDelete = getAllSalesByEvent(event);
        for(Sales sale : salesToDelete) {
            DB.remove(sale);
        }
        saveSales();
        audit.deleteAction(salesToDelete.toString(), csvSale);
        return 1;
    }
}
