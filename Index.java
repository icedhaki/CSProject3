import java.util.Iterator;
/**
 * A interface for implementations of methods to be used by the mapping algorithms
 *
 * @author Khaknazar Shyntassov
 * @version 11/24/2020
 */
public interface Index
{
    /**
     * Searches storage device to see if it contains the word, if not adds a new one, if so, then adds to that word the line number
     *
     * @param  w  The word to be added
     * @return    If the insertion is successful
     */
    boolean searchAndAdd(String w, int line);
    
    /**
     * Finds the total number of words encountered
     * 
     * @return    the number of words
     */
    int size();
    
    /**
     * Gives the data as an array
     * 
     * @return    the array
     */
    //void toArray(Entry[] array);
}
