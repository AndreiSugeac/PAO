package Backend.CsvFile;

import java.io.IOException;
import java.sql.Timestamp;

public class Audit extends CsvWriter{

    private static final String auditPath = "Audit.csv";

    public Audit() {
        super(auditPath, true);
    }

    public void insertAction(String Data, String Location) {
        try {
            this.getFw().append("Inserted " + Data + " to " + Location + ", " + (new Timestamp(System.currentTimeMillis())).toString());
            this.getFw().append("\n");
            this.getFw().flush();
        } catch (IOException e) {
            System.out.println("Error while appending insert action to Audit");
            e.printStackTrace();
        }
    }

    public void deleteAction(String Data, String Location) {
        try {
            this.getFw().append("Deleted " + Data + " from " + Location + ", " + (new Timestamp(System.currentTimeMillis())).toString());
            this.getFw().append("\n");
            this.getFw().flush();
        } catch (IOException e) {
            System.out.println("Error while appending delete action to Audit");
            e.printStackTrace();
        }
    }

    public void closeAudit() {
        this.closeFile();
    }

    public static String getAuditPath() {
        return auditPath;
    }
}
