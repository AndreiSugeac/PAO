package CsvFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {

    private static final String BASE_PATH = "D:/PAO/OOP_Project/src/";
    private FileReader fr;
    private List<String[]> data = new ArrayList<>();
    private String lineSplit = ",";

    public CsvReader(String path) {

        try {
            this.fr = new FileReader(BASE_PATH + path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readCSV() {
        String line;
        try(BufferedReader br = new BufferedReader(fr)) {
            //br.readLine(); // skip the header row
            while((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBasePath() {
        return BASE_PATH;
    }

    public FileReader getFr() {
        return fr;
    }

    public String getLineSplit() {
        return lineSplit;
    }

    public List<String[]> getData() {
        return data;
    }

    public void printData() {
        for(String[] str : data) {
            System.out.println(Arrays.toString(str));
        }
    }
}
