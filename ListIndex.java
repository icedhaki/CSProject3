
/**
 * Write a description of class ListIndex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class ListIndex implements Index
{
    // instance variables - replace the example below with your own
    private ArrayList<Entry> list;

    /**
     * Constructor for objects of class ListIndex
     */
    public ListIndex()
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
        if(this.list == null){
            return false;
        }
        
        int low = 0;
        int high = this.list.size()-1;
        int mid;
        
        while(low<=high){
            mid = (low+high)/2;
            if(this.list.get(mid).getWord().compareTo(w)<0){
                low = mid + 1;
            }
            else if(this.list.get(mid).getWord().compareTo(w)>0){
                high = mid - 1;
            }
            else{
                this.list.get(mid).addLine(k);
                return true;
            }
        }
        
        Entry e = new Entry(w,k); // create new entry
        this.list.add(low,e); // add new Entry to the list
        
        return true;
    }
}
