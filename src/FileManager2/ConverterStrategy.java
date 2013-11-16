
package FileManager2;

/**
 * This is the general contract for all implementations of the Converter Strategy
 * 
 * @author Teresa Mahoney
 */
public interface ConverterStrategy<T> {
    
    public abstract T decodeFormat(String s);
    
}
