package streams;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Ex1 {

    private static final String BASE_PATH = "D:/PAO/Laboratorul7/src/streams";

    public static void main(String[] args) {
        // get file separator
        System.out.println(System.getProperty("file.separator"));
        System.out.println(File.separator);

        // create director
        File dir1 = new File(BASE_PATH, "/dir1");
        System.out.println(dir1.mkdir());

        File dir2 = new File(BASE_PATH, "/a/b/c/dir2");
        System.out.println(dir2.mkdirs());

        // create new file
        File file1 = new File(BASE_PATH, "file1.txt");
        try {
            if (file1.createNewFile()) {
                System.out.println("file created");
            } else {
                System.out.println(file1.exists());
                System.out.println(file1 + "already exists");
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println(file1.getName());
        System.out.println(file1.length());
        System.out.println(file1.getAbsolutePath());

        File f1 = new File("D:/PAO/Laboratorul7/src/exceptions");
        System.out.println(Arrays.toString(f1.listFiles()));
    }
}
