
package FileManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This implementation converts a text file to a Map 
 * @author Owner
 */
public class TextConverter implements FormatConverter{
    
       
    
    @Override
    public Map convert(List<String> fileContent) {
        Map fileMap=new HashMap();
        // do work here
        for(int i=0; i<fileContent.size(); i++){
            fileMap.put(i,fileContent.get(i));
        }
        
        // end work
        return fileMap;
    }
    
}
