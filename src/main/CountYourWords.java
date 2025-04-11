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
        // Sort the words first
        ArrayList<String> sortedWords = Sort.insertionSort(wordCounts.keySet().toArray(new String[0]));

        // Now to add the values back
        for (String word: sortedWords) {
            String value = Integer.toString(wordCounts.get(word));
            String fString = word + " " + value;
            sortedWordCounts.add(fString);
        }
        
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
        
        HashMap<String, Integer> wordCounts = new HashMap<>();
        int totalCount = 0;

        for (String line : fileLines) {
            if (line == null || line.trim().length() == 0) continue;

            // Case insensitive +  strange combinations aren't present (love4u or mail@address.nl)
            String[] words = line.toLowerCase().replaceAll("[^a-z\\s]", "").split(" ");

            // Adding to counts
            for (String word: words) {
                if (word.isEmpty()) continue;
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
        Scanner sc = new Scanner(file);
        sc.useDelimiter("[.]");

        while (sc.hasNext()) {
            fileLines.add(sc.next().trim());
        }

        sc.close();
        return fileLines;
    }
}