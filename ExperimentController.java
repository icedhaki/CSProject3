
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
    static String[] bookNames = null; //list of names of all the books to be run

    /**
     * Times the amount of time it takes to run the line search using an ArrayList
     * 
     * @param  name  the name of the book to be indexed
     * @return    the time to complete the word search
     */
    public static long timeListIndex (String name) {
        ListIndex list = new ListIndex();
        int lineNum = 0;
        File file = new File(name);
        Scanner s = null;
        try {//opens a scanner and adds all words to the tree multiset
            s = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        long startTime = System.currentTimeMillis();        

        if (s == null) return -1; //ensures that the file has been found
        while (s.hasNextLine()) { //adds all words to the list, sorts them, etc.
            lineNum++;
            String line = s.nextLine(); // make it lowercase
            String[] words = line.split("[ˆA-Za-z]+"); // exclude punctuation
            for(int i=0; i<words.length; i++){
                list.searchAndAdd(words[i].toLowerCase(),lineNum);
            }
        }
        s.close();
        long endTime = System.currentTimeMillis();

        //creates output file, adds all entries to it
        Entry[] entries = list.toArray();
        FileWriter output = null;
        try {
            output = new FileWriter(name.substring(0, name.length()-4) + "_index.txt");
            for (Entry word : entries) {
                output.write(word.toString());
            }
            output.close();
        }
        catch (Exception e) {
            System.out.println("write failure");
            System.out.println(e);
        }
        return endTime - startTime;
    }

    /**
     * Times the amount of time it takes to run the line search using an TreeMap
     * 
     * @param  name  the name of the book to be indexed
     * @return    the time to complete the word search
     */
    public static long timeTreeMap (String name) {
        TreeIndex list = new TreeIndex();
        int lineNum = 0;
        File file = new File(name);
        Scanner s = null;
        try {//opens a scanner and adds all words to the tree multiset
            s = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        
        long startTime = System.currentTimeMillis();        

        if (s == null) return -1; //ensures that the file has been found
        while (s.hasNextLine()) { //adds all words to the list, sorts them, etc.
            lineNum++;
            String line = s.nextLine(); // make it lowercase
            String[] words = line.split("[ˆA-Za-z]+"); // exclude punctuation
            for(int i=0; i<words.length; i++){
                list.searchAndAdd(words[i].toLowerCase(),lineNum);
            }
        }
        s.close();
        long endTime = System.currentTimeMillis();

        //creates output file, adds all entries to it
        Entry[] entries = list.toArray();
        FileWriter output = null;
        try {
            output = new FileWriter(name.substring(0, name.length()-4) + "_index.txt");
            for (Entry word : entries) {
                output.write(word.toString());
            }
            output.close();
        }
        catch (Exception e) {
            System.out.println("write failure");
            System.out.println(e);
        }
        return endTime - startTime;
    }

    /**
     * Times the amount of time it takes to run the line search using an HashMap
     * 
     * @param  name  the name of the book to be indexed
     * @return    the time to complete the word search
     */
    public static long timeHashMap (String name) {
        HashIndex list = new HashIndex();
        int lineNum = 0;
        File file = new File(name);
        Scanner s = null;
        try {//opens a scanner and adds all words to the tree multiset
            s = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        long startTime = System.currentTimeMillis();        

        if (s == null) return -1; //ensures that the file has been found
        while (s.hasNextLine()) { //adds all words to the list, sorts them, etc.
            lineNum++;
            String line = s.nextLine(); // make it lowercase
            String[] words = line.split("[ˆA-Za-z]+"); // exclude punctuation
            for(int i=0; i<words.length; i++){
                list.searchAndAdd(words[i].toLowerCase(),lineNum);
            }
        }
        s.close();
        long endTime = System.currentTimeMillis();

        //creates output file, adds all entries to it
        Entry[] entries = list.toArray();
        FileWriter output = null;
        try {
            output = new FileWriter(name.substring(0, name.length()-4) + "_index.txt");
            for (Entry word : entries) {
                output.write(word.toString());
            }
            output.close();
        }
        catch (Exception e) {
            System.out.println("write failure");
            System.out.println(e);
        }
        return endTime - startTime;
    }

    /**
     * Main method - overall experiment running
     */
    public static void main(String[] args){
        bookNames = args;
        long listIndexTime = 0;
        long treeMapTime = 0;
        long hashMapTime = 0;
        for (String book : bookNames) {
            listIndexTime = timeListIndex(book);
            treeMapTime = timeTreeMap(book);
            hashMapTime = timeHashMap(book);
            
            System.out.println(book + "times");
            System.out.println("List Index: " + listIndexTime);
            System.out.println("Tree Map: " + treeMapTime);
            System.out.println("Hash Map: " + hashMapTime);
        }
    }
}
