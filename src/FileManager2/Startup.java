package FileManager2;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the main driver class for this FileManager Utility package.
 *
 * @author Teresa Mahoney
 */
public class Startup {

    public static void main(String[] args) {

        FileService fs;
        FileReaderStrategy frs;
        String filepath = "C:/temp/pipedelim.txt";

        fs = new FileService(filepath);
        Map returnedFileData = fs.ReadFile(new TextReader(filepath));
        System.out.println(returnedFileData);
        
        // as per lab 1 - read just 2nd record
        System.out.println("\nThis is the 2nd record:\n");
        System.out.println(returnedFileData.get(2));
    }
}
