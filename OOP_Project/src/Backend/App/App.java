package Backend.App;

import Backend.JDBC.JdbcConnection;

import java.util.Scanner;


public class App {
    private final JdbcConnection JDBC_CONNECTION = new JdbcConnection();

    public static void main(String[] args) {
        App app = new App();
        app.JDBC_CONNECTION.connect();
        while(true) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Type 0 to end the program!");
            int finish = keyboard.nextInt();
            if(finish == 0) {
                break;
            }
        }
        app.JDBC_CONNECTION.close();
    }
}
