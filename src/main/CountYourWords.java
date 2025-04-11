package main;
import java.io.File;
import java.io.FileNotFoundException;
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
     * Count words in text file. The function will convert everything into lower case and remove numbers or symbols.
     * 
     * @param List of Strings
     * @return Int totalWords, HashMap[String, Integer] wordCounts
     */
    public static Pair count(ArrayList<String> fileLines) throws IllegalArgumentException {
        if (fileLines == null) throw new IllegalArgumentException();
        
        // Variables
        HashMap<String, Integer> wordCounts = new HashMap<>();
        int totalCount = 0;

        for (String line : fileLines) {
            if (line == null) continue;

            // Case insensitive +  strange combinations aren't present (love4u or mail@address.nl)
            String[] words = line.toLowerCase().replaceAll("[^a-z\\s]", "").split(" ");

            // Adding to counts
            for (String word: words) {
                totalCount += 1;
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        return new Pair(totalCount, wordCounts);
    }

    /*
    * Reads the file, it is assumed that the file uses periods as delimiters.
    *
    * @param path the file path
    * @return List of Strings
    * @throws FileNotFoundException if the file is not found
    */
    public static ArrayList<String> readFile(String path) throws FileNotFoundException {
        ArrayList<String> fileLines = new ArrayList<>();
        File file = new File(path);

        try (Scanner sc = new Scanner(file)) {
            sc.useDelimiter(".");

            while (sc.hasNext()) {
                fileLines.add(sc.next());
            }
        }

        return fileLines;
    }
}