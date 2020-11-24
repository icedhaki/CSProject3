
/**
 * Write a description of class ExperimentController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class ExperimentController
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class ExperimentController
     */
    public static void main(String[] args){
        try {
            File file = new File("Shakespeare.txt");
            Scanner scanner = new Scanner(file);
            Integer lineNum = 0;
            ListIndex l = new ListIndex();
            // add words to a TreeMultiSet
            while (scanner.hasNextLine()) {
                lineNum++;
                String line = scanner.nextLine(); // make it lowercase
                String[] words = line.split("[ˆA-Za-z]+"); // exclude punctuation
                for(int i=0; i<words.length; i++){
                    l.searchAndAdd(words[i].toLowerCase(),lineNum);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        
    }
}
