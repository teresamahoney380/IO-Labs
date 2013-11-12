package FileManager;

import java.util.List;
import java.util.Map;

/**
 * This represents the contract for all Format Converters
 *
 * @author Teresa Mahoney
 */
public interface FormatConverter {
    // public abstract Map convert(String fileContent);

    public abstract Map convert(List<String> fileContent);
//    
//    public abstract Map convert(String[] fileContent);
}
