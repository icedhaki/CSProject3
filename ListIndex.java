
/**
 * Implementations for ArrayList
 *
 * @author Khaki
 * @version 11/24/2020
 */
import java.util.*;
public class ListIndex implements Index
{
    // instance variables - replace the example below with your own
    private ArrayList<Entry> list;

    /**
     * Constructs the ListIndex
     */
    public ListIndex()
    {
        // initialise instance variables
    }

    /**
     * Searches ArrayList to see if it contains the word, if not adds a new one, if so, then adds to that word the line number
     *
     * @param  w  The word to be added
     * @return    If the insertion is successful
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

    /**
     * Finds the total number of words encountered
     * 
     * @return    the number of words
     */
    public int size() {
        return this.list.size();
    }
    
    /**
     * Gives the data as an array
     * 
     * @return    the array
     */
    public Entry[] toArray() {
        return (Entry[])this.list.toArray();
    }
}
