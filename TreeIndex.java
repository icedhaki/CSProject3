
/**
 * Implementations for TreeMap
 *
 * @author Khaknazar Shyntassov
 * @version 11/24/2020
 */
import java.util.*;
public class TreeIndex implements Index
{
    // instance variables - replace the example below with your own
    private TreeMap<String, ArrayList<Integer>> map;

    /**
     * Constructs a TreeMap
     */
    public TreeIndex()
    {
        map = new TreeMap<String, ArrayList<Integer>>();
    }

    /**
     * Searches TreeMap to see if it contains the word, if not adds a new one, if so, then adds to that word the line number
     *
     * @param  w  The word to be added
     * @return    If the insertion is successful
     */
    public boolean searchAndAdd(String w, Integer k){
        if(this.map.isEmpty()){
            return false;
        }
        
        if(this.map.containsKey(w)){
            ArrayList<Integer> set = this.map.get(w);
            set.add(k);
            this.map.replace(w,set);
            return true;
        }
        
        ArrayList<Integer> set = new ArrayList<Integer>();
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
     * Gives the data as an array
     * 
     * @return    the array
     */
    public Entry[] toArray() {
        return (Entry[])this.map.values().toArray();
    }
}
