
/**
 * Write a description of class checkWithOut here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class checkWithOut
{
    public static void main(String[] args){
        check();
    }
    
    public static void check() {
        
        ArrayList<String> dictionary = new ArrayList<String>();
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
        
        ListIndex list1 = new ListIndex();
        
        try {
            File file = new File("Shakespeare.txt");
            Scanner scanner = new Scanner(file);
            int lineNum = 0;
            // add words to a TreeMultiSet
            while (scanner.hasNext()) {
                lineNum++;
                String line = scanner.nextLine();
                String[] words = line.split("[\\p{Punct}\\s]+");
                for(String w : words){
                    w=w.toLowerCase();
                    if(Collections.binarySearch(dictionary,w)>0){
                        list1.searchAndAdd(w,lineNum); // exclude punctuation
                    }
                }
            }
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
            fileStream = new PrintStream(new File("Shakespeare_index.txt"));
            for (Entry word : entries) {
                fileStream.println(word.toString());
            }
            fileStream.close();
        }
        catch (Exception e) {
            System.out.println("write failure");
            System.out.println(e);
        }
    }
}
