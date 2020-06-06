package Backend.CsvFile;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {

    private static final String BASE_PATH = "D:/PAO/OOP_Project/src/";
    private FileWriter fw;

    public CsvWriter(String fileName) {
        try {
            fw = new FileWriter((BASE_PATH + fileName), false);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public CsvWriter(String fileName, Boolean append) {
        try {
            fw = new FileWriter((BASE_PATH + fileName), append);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public <T> void writeToCsv(String data) {
        try {
            fw.append(data);
            fw.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFile() {
        try {
            fw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public FileWriter getFw() {
        return fw;
    }
}
