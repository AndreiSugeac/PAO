package System;

import java.util.UUID;

public class Client extends Person implements Comparable<Client> {

    private UUID id_client;

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

    @Override
    public int compareTo(Client o) {
        return this.getAge() - o.getAge();
    }
}
