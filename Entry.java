
/**
 * Write a description of class Entry here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Entry
{
    // instance variables - replace the example below with your own
    private String word;
    private TreeSet<Integer> set;
    /**
     * Constructor for objects of class Entry
     */
    public Entry(String word,Integer line)
    {
        this.word = word;
        addLine(line);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addLine(Integer line){
        set.add(line);
    }
    
    public String getWord(){
        return this.word;
    }
    
    public TreeSet<Integer> getSet(){
        return this.set;
    }
}
