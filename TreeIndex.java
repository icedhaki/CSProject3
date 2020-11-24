
/**
 * Write a description of class TreeIndex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class TreeIndex implements Index
{
    // instance variables - replace the example below with your own
    private TreeMap<String, TreeSet<Integer>> map;

    /**
     * Constructor for objects of class TreeIndex
     */
    public TreeIndex()
    {
        // initialise instance variables
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean searchAndAdd(String w, Integer k){
        if(this.map.isEmpty()){
            return false;
        }
        
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
}
