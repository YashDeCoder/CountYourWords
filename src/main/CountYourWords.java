package main;
import java.util.ArrayList;
import java.util.HashMap;

public class CountYourWords {
    /*
     * Sorting method for dictionaries
     * 
     * @param HashMap[String, Integer] wordCounts
     * @return HashMap[String, Integer] SortedWordCounts
     */
    public static HashMap<String, Integer> sort(HashMap<String, Integer> wordCounts) {
        HashMap<String, Integer> sortedWordCounts = new HashMap<>();
        return sortedWordCounts;
    }
    
    /*
     * Counting words in text file
     * 
     * @param List of Strings
     * @return Int totalWords, HashMap[String, Integer] wordCounts
     */
    public static Pair count(ArrayList<String> fileLines) {
        HashMap<String, Integer> wordCounts = new HashMap<>();
        int totalCount = 0;

        return new Pair(totalCount, wordCounts);
    }

    /*
     * Reads the file
     * 
     * @param String path
     * @return List of Strings
     */
    public static ArrayList<String> readFile(String path) throws Exception {
        ArrayList<String> fileLines = new ArrayList<>();

        return fileLines;
    }
}