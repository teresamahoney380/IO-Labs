package lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This program meets the Lab 3 assignment to read only the 2nd record and
 * output only the city.
 *
 * @author Teresa Mahoney
 */
public class IOLab3 {

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
        // get the second record
        int spaceCount = 0;
        char rChar;
        String city = "";
        String result = fileMap.get(1);
        // got the record - System.out.println(result);
        // char[] resultArr = result.toCharArray();
        for (int j = 0; j < result.length(); j++) {
            rChar = result.charAt(j);
            // System.out.println(result.length());
            if (rChar == ' ') {
                spaceCount += 1;
                
                if (spaceCount == 5) {
                   while (result.charAt(j) != ',') {
                        j += 1;
                        rChar = result.charAt(j);
                        if(result.charAt(j) != ',')city += rChar;
                        
                    } 
                    break;
                }

            }
        }
        System.out.println(city);
    }// end Main
}// end class