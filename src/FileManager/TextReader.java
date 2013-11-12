
package FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This implementation reads the contents of a Text File
 * @author Teresa Mahoney
 */
public class TextReader implements IFileReader{
    private FormatConverter converter;
    private String filePath;
    
    public TextReader(FormatConverter c,String path){
        this.converter = c;
        this.filePath=path;
    }

    @Override
    public Map readFile(FormatConverter fc, String path) {
       List fileList = new ArrayList();
       BufferedReader in = null;
       File data = new File(path);
        try {
            in = new BufferedReader(new FileReader(data));
            String line = in.readLine();
            while (line != null) {
                fileList.add(line);
                line = in.readLine();  // strips out any carriage return chars
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TextReader.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           try {
               in.close();
           } catch (IOException ex) {
               Logger.getLogger(TextReader.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        //FileConverter tc=(FileConverter) new TextConverter();
        Map fileMap=converter.convert(fileList);
        return fileMap;
        
    }
    public static void main(String[] args) {
        
        TextConverter tc= new TextConverter();
        TextReader  TR = new TextReader(tc, "C:/temp/lab4 custom.txt");
        Map m = TR.readFile(tc, "C:/temp/lab4 custom.txt");
        System.out.println(m);
    }

   
    
}
