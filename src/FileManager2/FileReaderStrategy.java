
package FileManager2;

/**
 * This represents the general contract for all file reader Strategy implementations.
 * Generics are used so that the return data type and the format of what is passed 
 * in to the readFile method can be determined by the individual implementation.
 * 
 * @author Teresa Mahoney
 */
public interface FileReaderStrategy <T,E> {
    
     public abstract T readFile(E element);
    
}
