
package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * This lab exercise reads a text file and outputs the data to the console. The second
 * segment reads only the 2nd record of the file. The third segment appends data to
 * the file and reads the file again and outputs it to the console to make sure the 
 * data appended.
 * 
 * @author Teresa Mahoney
 */
public class IOLab1 {
    
    public static void main(String[] args) throws IOException
    {
       File data = new File("C:" + File.separatorChar + "temp"+File.separatorChar+"IOLab1.txt"); 
        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
	   while(line != null){
		  System.out.println(line);
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
        
        // Segment 2 of lab 1 - read only 2nd record of file
        
        Map<Integer,String> fileMap;
        fileMap = new HashMap();
        
        try {
	   in = new BufferedReader(new FileReader(data));
           int i = 0;
	   String line = in.readLine();
	   while(line != null){
		  fileMap.put(i,line);
                  i+=1;
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
            System.out.println("\nThis is the 2nd record in the file: \n");
            System.out.println(fileMap.get(1));
            System.out.println("");
        }
        //--------------- end Segment 2 -----------------------
        
        // Segment 3 of lab 1 appends records to file then rereads and outputs
        // record to console 
        
        boolean append = true;
        PrintWriter out = new PrintWriter(
						new BufferedWriter(
						new FileWriter(data, append)));
        //out.println();
        out.println("Larry Last 999 Ninth Ave Lasttown, WI 99999 ll@gmail.com 909-999-9999");
        out.close();
        
        // reread file and output to console
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
	   while(line != null){
		  System.out.println(line);
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
        //----------------- end Segment 3
        
    }// end Main
    
}// end Class
