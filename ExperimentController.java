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
     * @return    the time to complete the word search
     */
    public static long timeListIndex (String name) {
        ListIndex list1 = new ListIndex();
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
                list1.searchAndAdd(words[i].toLowerCase(),lineNum);
            }
        }
        s.close();
        long endTime = System.currentTimeMillis();
        /*
        //creates output file, adds all entries to it
        Entry[] entries = list1.toArray();
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
        */
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
        /*
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
        */
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

        /*
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
        */
        return endTime - startTime;
    }

    /**
     * Main method - overall experiment running
     */
    public static void main(String[] args){
        String[] bookNames = {"book0.txt","book1.txt","book2.txt","book3.txt","book4.txt","book5.txt","book6.txt","book7.txt"};
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
