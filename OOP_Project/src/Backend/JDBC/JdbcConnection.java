package Backend.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private final String url = "jdbc:postgresql://localhost:5432/ticketdb";
    private final String user = "postgres";
    private final String password = "baschetball99";
    private static Connection connection;
    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to Postgresql DB successful");
        } catch (SQLException e) {
            System.out.println("Error connecting to Postgresql");
            e.printStackTrace();
        }

    }

    public void close() {
        try {
            if(connection != null) {
                connection.close();
                System.out.println("Connection to Postgresql was successfully closed");
            }
        } catch (SQLException e) {
            System.out.println("Error trying to close the connection to Postgres");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
