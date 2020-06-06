package Backend.JDBC;

import Backend.System.Services.EventServices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class TestJDBC {

    private final JdbcConnection jdbcConnection = new JdbcConnection();

    public static void main(String[] args) {
        TestJDBC testJDBC = new TestJDBC();
        testJDBC.jdbcConnection.connect();
        EventServices eventServices = new EventServices();
        if(JdbcConnection.getConnection() != null)
            while(true) {
                Scanner scanner = new Scanner(System.in);
                int command = scanner.nextInt();
                if(command == 0)
                    break;
                String sql = "SELECT * FROM event";
                try {
                    Statement statement = JdbcConnection.getConnection().createStatement();
                    ResultSet result = statement.executeQuery(sql);
                    while(result.next()) {
                        String ev_name = result.getString("event_name");
                        LocalDate date = LocalDate.parse(result.getString("date"));
                        LocalTime time = LocalTime.parse(result.getString("start_hour"));
                        String country = result.getString("country");
                        String city = result.getString("city");
                        String venue = result.getString("venue");
                        System.out.println(ev_name + ", " + date + ", " + time + ", " + country + ", " + city + ", " + venue);
                    }
                    System.out.println("Event name: ");
                    scanner.nextLine();
                    String eventName = scanner.nextLine();
                    System.out.println(eventName);
                    System.out.println(eventServices.getEventByName(eventName));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        testJDBC.jdbcConnection.close();
    }
}
