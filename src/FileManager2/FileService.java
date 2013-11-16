
package FileManager2;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides File IO services
 * @author Teresa Mahoney
 */
public class FileService {
    String filePath;
    
    public FileService(String path){
        this.filePath = path;
        
    }
    
    public Map ReadFile(FileReaderStrategy r){
        Map fileData = new HashMap();
        fileData = (Map) r.readFile(filePath);
        return fileData;
    }
    
}
