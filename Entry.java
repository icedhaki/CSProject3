
/**
 * An entry, containing each line where a word is located
 *
 * @author Khaki
 * @version 11/24/2020
 */
import java.util.*;
public class Entry
{
    // instance variables - replace the example below with your own
    private String word;
    private ArrayList<Integer> set = new ArrayList();
    /**
     * Constructs an entry with a given word and the line where it first appears
     * 
     * @param  word  the word to be added
     * @param  line  the line where the word is first located
     */
    public Entry(String word,Integer line)
    {
        this.word = word;
        addLine(line);
    }

    /**
     * Adds another line to the list of lines that the word appears
     *
     * @param  line  the line number to be added
     */
    public void addLine(Integer line){
        set.add(line);
    }
    
    /**
     * Gets the word
     * 
     * @return    the word
     */
    public String getWord(){
        return this.word;
    }
    
    /**
     * Gets the list of all lines where the word appeared
     * 
     * @return    the set
     */
    public ArrayList<Integer> getList(){
        return this.set;
    }
    
    /**
     * Returns a string representation of the word and it's associated line numbers.
     */
    public String toString() {
        return word + " " + this.set.toString();
    }
}
