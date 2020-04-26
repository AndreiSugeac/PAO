package System.Model;

import CsvFile.CsvReader;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client extends Person implements Comparable<Client> {

    private UUID id_client;
    private static String csvClient = "Client.csv";
    private static int maxClients = 10;
    private static List<Client> clients = new ArrayList<Client>();

    public Client(String name, int age) {
        super(name, age);
        this.id_client = UUID.randomUUID();
    }

    public Client(String name, int age, UUID id) {
        super(name, age);
        this.id_client = id;
    }

    public UUID getId_client() {
        return id_client;
    }

    public void setId_client(UUID id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "Client{" +
                super.toString() +
                ", id=" + id_client +
                "}";
    }

    public String toStringCsv() {
        return "" + super.toStringCsv() +
                "," + id_client;
    }

    @Override
    public int compareTo(Client o) {
        return this.getAge() - o.getAge();
    }
}
