
package FileManager;

import java.util.Map;

/**
 * This is the service program that provides the gateway to launch all file services.
 * 
 * @author Teresa Mahoney
 */
public class FileService {
    private IFileReader reader;
    
    public FileService(IFileReader r){
        this.reader = r;
        
    }
    public Map readFile(FormatConverter fc,String path){
        
        Map fileMap=reader.readFile(fc, path);
        return fileMap;
    }
    
}
