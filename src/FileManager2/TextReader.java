
package FileManager2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This implementation reads a text file from the path parm passed in and returns
 * it in the form of a HashMap for processing
 * 
 * @author Teresa Mahoney
 */
public class TextReader implements FileReaderStrategy<Map, String>{

    /**
     * This method reads a text file format and returns it in the form of a
     * HashMap with record numbers for the key
     * @param path - this is passed into the class and is the path of the file to be read
     * @return fileMap - this is the data read in from the text file in the form of
     *                   a HashMap
     */
    
    private String filepath;
    private ConverterStrategy c;
    
    public TextReader(String filepath){
      this.filepath=filepath; 
      c = new DelimConverter("\\|","");
    }
    
    @Override
    public Map readFile(String path) {
        Map fileMap=new HashMap();
        Map dataline = new HashMap();
        
        int i = 1;
        
         
       BufferedReader in = null;
       File data = new File(path);
        try {
            in = new BufferedReader(new FileReader(data));
            String line = in.readLine();
            while (line != null) {
                dataline = (Map) c.decodeFormat(line);
                fileMap.put(i,dataline );
                i++;
                line = in.readLine();  // strips out any carriage return chars
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.TextReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.TextReader.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           try {
               in.close();
           } catch (IOException ex) {
               Logger.getLogger(FileManager.TextReader.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        return fileMap;
        
    }
    
//    // test this class
//    public static void main(String[] args) {
//        TextReader  TR = new TextReader("C:/temp/pipedelim.txt");
//        Map m = TR.readFile("C:/temp/pipedelim.txt");
//        System.out.println(m);
//    }
    
}
