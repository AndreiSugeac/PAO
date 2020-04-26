package System.Services;

import System.Dao.DataBase;
import System.Model.Client;

import java.util.UUID;

public class ClientServices extends Services {

    public int insertClient(Client client) {
        return getDataBase().addClient(client);
    }

    public int updateClient(UUID id, Client client) {
        return getDataBase().updateClientById(id, client);
    }

    public int deleteByClient(UUID id) {
        return getDataBase().deleteSaleByClientId(id);
    }

}
