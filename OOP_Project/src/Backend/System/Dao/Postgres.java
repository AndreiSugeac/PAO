package Backend.System.Dao;

import Backend.CsvFile.Audit;
import Backend.JDBC.JdbcConnection;
import Backend.System.Model.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Postgres implements Dao{

    private static String csvClient = "Client.csv";
    private static String csvEvent = "Event.csv";
    private static String csvSale = "Sales.csv";
    private static final Audit audit = new Audit();

    /// POST REQUESTS
    @Override
    public int insertSale(Sales sales) {
        final String sql = "INSERT INTO sales (ticket_id, client_id) VALUES (?, ?)";
        if(JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Post Request!");
            return 0;
        }
        try (PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setObject(1, sales.getTicket().getTicket_id());
            preparedStatement.setObject(2, sales.getClient().getId_client());

            addClient(sales.getClient());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        audit.insertAction(sales.toString(), csvSale);
        return 1;
    }

    @Override
    public int addEvent(Event event) {
        final String sql = "INSERT INTO event (event_name, date, start_hour, country, city, venue, event_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        if(JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Post Request!");
            return 0;
        }
        try (PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, event.getNameEvent());
            preparedStatement.setDate(2, Date.valueOf(event.getDate()));
            preparedStatement.setTime(3, Time.valueOf(event.getStartingHour()));
            preparedStatement.setString(4, event.getLocation().getCountry());
            preparedStatement.setString(5, event.getLocation().getCity());
            preparedStatement.setString(6, event.getLocation().getVenue());
            preparedStatement.setObject(7, event.getEvent_id());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        audit.insertAction(event.toString(), csvEvent);
        return 1;
    }

    @Override
    public int addClient(Client client) {
        final String sql = "INSERT INTO client (id_client, name, age) VALUES (?, ?, ?)";
        if(JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Post Request!");
            return 0;
        }
        try (PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setObject(1, client.getId_client());
            preparedStatement.setString(2, client.getName());
            preparedStatement.setInt(3, client.getAge());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        audit.insertAction(client.toString(), csvClient);
        return 1;
    }


    public int addTicket(Ticket ticket) {
        final String sql = "INSERT INTO ticket (ticket_id, eventid) VALUES (?, ?)";
        if(JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Post Request!");
            return 0;
        }
        try (PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setObject(1, ticket.getTicket_id());
            preparedStatement.setObject(2, ticket.getEvent().getEvent_id());
            System.out.println("here");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }


    /// GET REQUESTS
    @Override
    public List<Sales> getAllSales() {
        List<Sales> temp_sales = new ArrayList<>();
        final String sql = "SELECT t.*, c.* FROM sales s" +
                " INNER JOIN ( SELECT * FROM ticket" +
                " INNER JOIN event ON ticket.eventid = event.event_id) t" +
                " USING (ticket_id)" +
                " INNER JOIN client c ON s.client_id = c.id_client";
        if(JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Get Request!");
            return null;
        }
        try {
            Statement statement = JdbcConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
                temp_sales.add(new Sales(new Ticket(UUID.fromString(result.getString("ticket_id")),
                                            new Event(UUID.fromString(result.getString("event_id")),
                                                    result.getString("event_name"),
                                                    LocalDate.parse(result.getString("date")),
                                                    LocalTime.parse(result.getString("start_hour")),
                                                    new Location(result.getString("country"),
                                                                 result.getString("city"),
                                                                 result.getString("venue")))),
                                            new Client(result.getString("name"), result.getInt("age"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp_sales;
    }

    public List<Event> getAllEvents() {
        final String sql = "SELECT * FROM event";
        List<Event> events = new ArrayList<>();
        if(JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Get Request!");
            return null;
        }
        try {
            Statement statement = JdbcConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                events.add(new Event(UUID.fromString(resultSet.getString("event_id")), resultSet.getString("event_name"),
                        LocalDate.parse(resultSet.getString("date")), LocalTime.parse(resultSet.getString("start_hour")),
                        new Location(resultSet.getString("country"), resultSet.getString("city"),
                                resultSet.getString("venue"))));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public Optional<Event> getEventByName(String eventName) {
        final String sql = "SELECT * FROM event WHERE event_name=?";
        Event event = null;
        if(JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Get Request!");
            return Optional.empty();
        }
        try {
            PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, eventName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                event = new Event(UUID.fromString(resultSet.getString("event_id")), resultSet.getString("event_name"),
                                LocalDate.parse(resultSet.getString("date")), LocalTime.parse(resultSet.getString("start_hour")),
                                        new Location(resultSet.getString("country"), resultSet.getString("city"),
                                                     resultSet.getString("venue")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(event);
    }


    public List<Client> getAllClients() {
        final String sql = "SELECT * FROM client";
        List<Client> clients = new ArrayList<>();
        if(JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Get Request!");
            return null;
        }
        try {
            Statement statement = JdbcConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                clients.add(new Client(resultSet.getString("name"), resultSet.getInt("age"),
                            UUID.fromString(resultSet.getString("id_client"))));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    // PUT REQUESTS
    public int updateClientById(UUID id, Client client) {
        String sql = "UPDATE client " +
                "INNER JOIN sales ON client.id_client=sales.client_id" +
                "SET name=?, age=?" +
                "WHERE id_client=?";
        if(JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Put Request!");
            return 0;
        }
        try {
            PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setInt(2, client.getAge());
            preparedStatement.setObject(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public int updateEventById(UUID id, Event event) {
        String sql = "UPDATE event" +
                "SET event_name=?, date=?, start_hour=?, country=?, city=?, venue=?" +
                "WHERE event_id=?";
        if(JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Put Request!");
            return 0;
        }
        try (PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, event.getNameEvent());
            preparedStatement.setDate(2, Date.valueOf(event.getDate()));
            preparedStatement.setTime(3, Time.valueOf(event.getStartingHour()));
            preparedStatement.setString(4, event.getLocation().getCountry());
            preparedStatement.setString(5, event.getLocation().getCity());
            preparedStatement.setString(6, event.getLocation().getVenue());
            preparedStatement.setObject(7, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    // DELETE REQUESTS
    public int deleteEventById(UUID id) {
        String sql = "DELETE FROM event WHERE event_id=?";
        if (JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Delete Request!");
            return 0;
        }
        try {
            PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(sql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        audit.deleteAction(csvEvent);
        return 1;
    }

    public int deleteClientById(UUID id) {
        String sql = "DELETE sales, ticket, client " +
                "FROM sales " +
                "INNER JOIN ticket ON sales.ticket_id = ticket.ticket_id" +
                "INNER JOIN client ON sales.client_id = client.id_client" +
                "WHERE id_client=?";
        if (JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Delete Request!");
            return 0;
        }
        try {
            PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(sql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        audit.deleteAction(csvClient);
        return 1;
    }

    public int deleteTicketById(UUID id) {
        String sql = "DELETE sales, ticket, client " +
                "FROM sales " +
                "INNER JOIN ticket ON sales.ticket_id = ticket.ticket_id" +
                "INNER JOIN client ON sales.client_id = client.id_client" +
                "WHERE ticket_id=?";
        if (JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Delete Request!");
            return 0;
        }
        try {
            PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(sql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public int deleteSaleById(UUID id) {
        String sql = "DELETE sales, ticket, client " +
                "FROM sales " +
                "INNER JOIN ticket ON sales.ticket_id = ticket.ticket_id" +
                "INNER JOIN client ON sales.client_id = client.id_client" +
                "WHERE sale_id=?";
        if (JdbcConnection.getConnection() == null) {
            System.out.println("Connection to Postgres not established! Can't execute Delete Request!");
            return 0;
        }
        try {
            PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(sql);
            preparedStatement.setObject(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        audit.deleteAction(csvSale);
        return 1;
    }
}
