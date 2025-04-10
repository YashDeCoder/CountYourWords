package main;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CountYourWords {
    /*
     * Sorting method for dictionaries. It assumes that wordCounts only contains lower case strings.
     * 
     * @param HashMap[String, Integer] wordCounts
     * @return ArrayList<String> sortedWordCounts
     */
    public static ArrayList<String> sort(HashMap<String, Integer> wordCounts) {
        ArrayList<String> sortedWordCounts = new ArrayList<>();
        return sortedWordCounts;
    }
    
    /*
     * Count words in text file. The function will convert everything into lower case.
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
     * Reads the file, it is assumed that the file uses periods as delimiters.
     * 
     * @param String path
     * @return List of Strings
     */
    public static ArrayList<String> readFile(String path) throws Exception {
        ArrayList<String> fileLines = new ArrayList<>();
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useDelimiter(".");

        while (sc.hasNextLine()) {
            fileLines.add(sc.nextLine());
        }

        sc.close();
        return fileLines;
    }
}