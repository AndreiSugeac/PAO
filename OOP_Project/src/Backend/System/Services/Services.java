package Backend.System.Services;

import Backend.System.Dao.Postgres;
import Backend.System.Dao.DataBase;

public class Services {
    private static final DataBase dataBase = new DataBase();
    private static final Postgres postgres = new Postgres();

    public static DataBase getDataBase() {
        return dataBase;
    }

    public static Postgres getPostgres() {
        return postgres;
    }
}
