package FileManager2;

import java.util.HashMap;
import java.util.Map;

/**
 * This implementation of the Converter Strategy converts a string with
 * delimiters to a List of Maps
 *
 * @author Teresa Mahoney
 */
public class DelimConverter implements ConverterStrategy {

    private String deliminator;
    private String dataLine;

    public DelimConverter(String d, String s) {
        this.deliminator = d;
        this.dataLine = s;

    }

    /**
     * This methods decodes the file data separated by delimiters into a list of Maps.
     * 
     * @param dataLine String line of data read from a text file with delimiters
     * @return HashMap of each data string between delimiters
     */
    @Override
    public Map decodeFormat(String dataLine) {
        Map dataMap = new HashMap<Integer, String>();
        String[] fields = dataLine.split(deliminator);
        int i = 1;
        for (String s : fields) {
            dataMap.put(i, s);
            //System.out.println(dataMap);
            i++;
        }
//        for (Object d : dataMap.keySet()) {
//            System.out.println(dataMap.get(d));
//        }

        return dataMap;
    }
//    //test code
//
//    public static void main(String[] args) {
//        DelimConverter DC = new DelimConverter("\\|", "Terry|Address|City");
//        DC.convertFormat("Terry|Address|City");
//    }
}
