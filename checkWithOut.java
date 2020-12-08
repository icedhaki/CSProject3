/**
 * checkWithOut class to compare our result with the provided txt file; this class is used for internal tests, including ensuring our result from Shakespeare.txt is the same as the out.txt, as such, not tested
 *
 * @author Khaknazar Shyntassov
 * @version 12/3/2020
 */

import java.util.*;
import java.io.*;
public class checkWithOut
{
    /**
     * main method runs simulation
     */
    public static void main(String[] args){
        check(); // run check
    }
    
    /**
     * check method adds English words found in Shakespeare's book, adds to TreeIndex and outputs result in a text file
     */
    public static void check() {
        ArrayList<String> dictionary = getDictionary(); // get dictionary of English words
        
        ListIndex list1 = new ListIndex();
        long startTime = 0;
        long stopTime = 0;
        try {
            File file = new File("Shakespeare.txt");//file to read from
            Scanner scanner = new Scanner(file);
            int lineNum = 0;
            // add words to a TreeMultiSet
            startTime = System.currentTimeMillis(); // record starting time
            // iterate through the file
            while (scanner.hasNext()) {
                lineNum++; // increment line number
                String line = scanner.nextLine(); // next line
                String[] words = line.split("[^a-zA-Z]"); // include only letters
                for(String w : words){
                    w=w.toLowerCase(); // turn to lower case
                    // search the word in the dictionary
                    if(Collections.binarySearch(dictionary,w)>0){
                        list1.searchAndAdd(w,lineNum); // run searchAndAdd
                    }
                }
            }
            stopTime = System.currentTimeMillis(); // record stopping time
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        
        
        //creates output file, adds all entries to it
                
        Entry[] entries = new Entry[list1.size()];
        for(int i=0;i<list1.size();i++){
            entries[i]=list1.getList().get(i);
        }
        
        
        PrintStream fileStream = null;
        try {
            fileStream = new PrintStream(new File("Shakespeare_listIndex.txt")); //file to write to
            for (Entry word : entries) {
                fileStream.println(word.toString()); // write all entries to a txt file
            }
            fileStream.close();
        }
        catch (Exception e) {
            System.out.println("write failure");
            System.out.println(e);
        }
        
    }
    
    /**
     * getDictionary method returns dictionary of English words
     * 
     * @return    The dictionary as an ArrayList
     */
    public static ArrayList<String> getDictionary(){
        ArrayList<String> dictionary = new ArrayList<String>(); // initialize dictionary
        // populate ArrayList with words from provided dictionary
        try {
            File file = new File("English.txt");
            Scanner scanner = new Scanner(file);
            // add words to a TreeMultiSet
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                dictionary.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
                
        return dictionary;
    }
}
