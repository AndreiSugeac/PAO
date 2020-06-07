package Backend.App;

import Backend.JDBC.JdbcConnection;
import GUI.AppFrame;

import java.util.Scanner;


public class App {
    private static JdbcConnection JDBC_CONNECTION;

    public App() {
        JDBC_CONNECTION = new JdbcConnection();
    }

    public static void main(String[] args) {
        App app = new App();
        JDBC_CONNECTION.connect();
        System.out.println(JdbcConnection.getConnection());
        if(JdbcConnection.getConnection() != null) {
            AppFrame appFrame = new AppFrame();
        }
    }

    public static void closeConnection() {
        JDBC_CONNECTION.close();
    }

    public static JdbcConnection getJdbcConnection() {
        return JDBC_CONNECTION;
    }
}
