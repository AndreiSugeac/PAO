package System.Services;

import System.Model.Client;
import System.Model.Event;
import System.Model.Sales;
import System.Model.Ticket;
import System.Dao.DataBase;

import java.util.List;
import java.util.UUID;

public class Services {
    private static final DataBase dataBase = new DataBase();

    public DataBase getDataBase() {
        return dataBase;
    }
}
