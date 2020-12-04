
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
        ListIndex list1 = new ListIndex();
        
        try {
            File file = new File("Shakespeare.txt");
            Scanner scanner = new Scanner(file);
            int lineNum = 0;
            // add words to a TreeMultiSet
            while (scanner.hasNext()) {
                lineNum++;
                String s = scanner.next().toLowerCase(); // make it lowercase
                list1.searchAndAdd(s.replaceAll("[^a-zA-Z ]", ""),lineNum); // exclude punctuation

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        
        /*
        int lineNum = 0;
        File file = new File("Shakespeare.txt");
        Scanner s = null;
        try {//opens a scanner and adds all words to the tree multiset
            s = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        while (s.hasNextLine()) { //adds all words to the list, sorts them, etc.
            lineNum++;
            String line = s.nextLine(); // make it lowercase
            String[] words = line.split(""); // exclude punctuation
            for(int i=0; i<words.length; i++){
                list1.searchAndAdd(words[i].toLowerCase(),lineNum);
            }
        }
        s.close();
        //creates output file, adds all entries to it
        */
        
        Entry[] entries = new Entry[list1.size()];
        for(int i=0;i<list1.size();i++){
            entries[i]=list1.getList().get(i);
        }
        
        
        FileWriter output = null;
        try {
            output = new FileWriter("Shakespeare_index.txt");
            for (Entry word : entries) {
                output.write(word.toString());
            }
            output.close();
        }
        catch (Exception e) {
            System.out.println("write failure");
            System.out.println(e);
        }
        
    }
}
