/**
 * Controls the Experiment
 *
 * @author Henry Grote
 * @version 11/29/2020
 */
import java.util.*;
import java.io.*;
public class ExperimentController
{
    /**
     * Times the amount of time it takes to run the line search using an ArrayList
     * 
     * @param  name  the name of the book to be indexed
     * @return the time to complete the word search
     */
    public static long timeListIndex (String name) {
        ArrayList<String> dictionary = getDictionary(); // get dictionary of English words
        
        ListIndex list1 = new ListIndex();
        long startTime = 0;
        long stopTime = 0;
        try {
            File file = new File(name);
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
            fileStream = new PrintStream(new File(name+"_listIndex.txt"));
            for (Entry word : entries) {
                fileStream.println(word.toString()); // write all entries to a txt file
            }
            fileStream.close();
        }
        catch (Exception e) {
            System.out.println("write failure");
            System.out.println(e);
        }
        
        return stopTime - startTime; // return time
    }

    /**
     * Times the amount of time it takes to run the line search using an TreeMap
     * 
     * @param  name  the name of the book to be indexed
     * @return    the time to complete the word search
     */
    public static long timeTreeMap (String name) {
        ArrayList<String> dictionary = getDictionary(); // get dictionary
        
        TreeIndex list1 = new TreeIndex();
        long startTime = 0;
        long stopTime = 0;
        try {
            File file = new File(name);
            Scanner scanner = new Scanner(file);
            int lineNum = 0;
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
        
        Set<String> keySet = list1.getMap().keySet(); // set of keys
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet); // ArrayList of map's keys
        Collection<TreeSet<Integer>> values = list1.getMap().values(); // Collection of map's values
        
        PrintStream fileStream = null;
        try {
            fileStream = new PrintStream(new File(name+"_treeIndex.txt"));
            Iterator it = values.iterator(); 
            int i=0;
            // iterate through Collection of map's values
            while (it.hasNext()){
                // print out keys and values
                fileStream.println(listOfKeys.get(i)+" "+it.next().toString());
                i++;
            }
            fileStream.close();
        }
        catch (Exception e) {
            System.out.println("write failure");
            System.out.println(e);
        }
        
        return stopTime - startTime; // return time
    }

    /**
     * Times the amount of time it takes to run the line search using an HashMap
     * 
     * @param  name  the name of the book to be indexed
     * @return    the time to complete the word search
     */
    public static long timeHashMap (String name) {
        ArrayList<String> dictionary = getDictionary(); // get dictionary
        
        HashIndex list1 = new HashIndex();
        long startTime = 0;
        long stopTime = 0;
        try {
            File file = new File(name);
            Scanner scanner = new Scanner(file);
            int lineNum = 0;
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
        
        Set<String> keySet = list1.getMap().keySet(); // set of keys
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet); // ArrayList of map's keys
        Collection<TreeSet<Integer>> values = list1.getMap().values(); // Collection of map's values
        
        PrintStream fileStream = null;
        try {
            fileStream = new PrintStream(new File(name+"_hashIndex.txt"));
            Iterator it = values.iterator(); 
            int i=0;
            // iterate through Collection of map's values
            while (it.hasNext()){
                // print out keys and values
                fileStream.println(listOfKeys.get(i)+" "+it.next().toString());
                i++;
            }
            fileStream.close();
        }
        catch (Exception e) {
            System.out.println("write failure");
            System.out.println(e);
        }
        
        return stopTime - startTime; // return time
    }
    
    /**
     * getDictionary method returns dictionary of English words
     * 
     * @param  no
     * @return ArrayList<String>
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

    /**
     * Main method - overall experiment running
     */
    public static void main(String[] args){
        String[] bookNames = {"book0.txt","book1.txt","book2.txt","book3.txt","book4.txt","book5.txt","book6.txt"};
        float listIndexTime = 0;
        float treeMapTime = 0;
        float hashMapTime = 0;
        // running experiments on different books
        for (String book : bookNames) {
            // running 5 trials
            for(int i=0;i<5;i++){
                listIndexTime = listIndexTime+timeListIndex(book);
                treeMapTime = treeMapTime+timeTreeMap(book);
                hashMapTime = hashMapTime+timeHashMap(book);
            }
            // calculating average times
            listIndexTime=listIndexTime/5;
            treeMapTime=treeMapTime/5;
            hashMapTime=hashMapTime/5;
            
            // printing times
            System.out.println(book + "times");
            System.out.println("List Index: " + listIndexTime);
            System.out.println("Tree Map: " + treeMapTime);
            System.out.println("Hash Map: " + hashMapTime);
        }
    }
}
