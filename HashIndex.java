
/**
 * Implementations for HashMap
 *
 * @author Khaknazar Shyntassov
 * @version 11/24/2020
 */
import java.util.*;
public class HashIndex implements Index
{
    // instance variables - replace the example below with your own
    private HashMap<String, TreeSet<Integer>> map;

    /**
     * Constructs a HashMap
     */
    public HashIndex()
    {
        map = new HashMap<String, TreeSet<Integer>>();
    }

    /**
     * Searches HashMap to see if it contains the word, if not adds a new one, if so, then adds to that word the line number
     *
     * @param  w  The word to be added
     * @return    If the insertion is successful
     */
    public boolean searchAndAdd(String w, int k)
    {
        if(this.map.containsKey(w)){
            TreeSet<Integer> set = this.map.get(w);
            set.add(k);
            this.map.replace(w,set);
            return true;
        }

        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(k);
        this.map.put(w,set);
        return true;
    }

    /**
     * Finds the total number of words encountered
     * 
     * @return    the number of words
     */
    public int size() {
        return this.map.size();
    }
    
    /**
     * Gets the map
     * 
     * @return    the map
     */
    public HashMap<String, TreeSet<Integer>> getMap(){
        return this.map;
    }
}
