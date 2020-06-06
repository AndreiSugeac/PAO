package Backend.CsvFile;

import java.io.File;
import java.io.IOException;

public class csv {

    private static final String BASE_PATH = "D:/PAO/OOP_Project/src/Backend.CsvFile/";
    private String csvName;

    public csv(String csvName) {
        this.csvName = csvName;
    }

    public void createFile() {

        File file = new File(BASE_PATH, this.csvName);
        try {
            if(file.createNewFile()) {
                System.out.println("File was created");
            } else {
                System.out.println(file.exists());
                System.out.println(file + "File exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
