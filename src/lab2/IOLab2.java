package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * This is a labe exercise designed to accept the input of any record number to
 * be read from the file.
 *
 * @author Teresa Mahoney
 */
public class IOLab2 {

    public static void main(String[] args) throws IOException {

        String inputStr;
        int i = 0;

        // convert the file to a HashMap
        File data = new File("C:" + File.separatorChar + "temp" + File.separatorChar + "IOLab1.txt");
        BufferedReader in = null;

        Map<Integer, String> fileMap;
        fileMap = new HashMap();

        try {
            in = new BufferedReader(new FileReader(data));
            //int i = 0;
            String line = in.readLine();
            while (line != null) {
                fileMap.put(i, line);
                i += 1;
                line = in.readLine();  // strips out any carriage return chars
            }

        } catch (IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }

        inputStr = JOptionPane.showInputDialog("Enter the record number to display:");
        i = Integer.parseInt(inputStr);
        
        // display the record
        
        JOptionPane.showMessageDialog(null, fileMap.get(i));
        
    }// end Main
}// end Class
