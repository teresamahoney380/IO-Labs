
package FileManager;

import java.util.Map;

/**
 * This is the contract for all FileReaders
 * @author Teresa Mahoney
 */
public interface IFileReader {
    
    public abstract  Map readFile(FormatConverter fc, String path);
    
}
