package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import main.CountYourWords;
import main.Pair;

public class CountYourWordsTest {
    // Sorting algorithm
    @Test
    public void sortEmptyTest() {
        HashMap<String, Integer> emptyMap = new HashMap<>();
        ArrayList<String> sortedArray = CountYourWords.sort(emptyMap);
        assertTrue("Array should be empty", sortedArray.isEmpty());
    }
    
    @Test
    public void sortSingleTest() {
        HashMap<String, Integer> singleMap = new HashMap<>();
        singleMap.put("apple", 1);
        ArrayList<String> sortedArray = CountYourWords.sort(singleMap);
        ArrayList<String> returnString = new ArrayList<>();
        returnString.add("apple 1");
        assertEquals(returnString, sortedArray);
    }
    
    @Test
    public void sortMultipleTest() {
        HashMap<String, Integer> multipleMap = new HashMap<>();
        multipleMap.put("cherry", 1);
        multipleMap.put("banana", 1);
        multipleMap.put("apple", 1);
        ArrayList<String> sortedArray = CountYourWords.sort(multipleMap);
        
        List<String> expectedKeys = Arrays.asList("apple 1", "banana 1", "cherry 1");
        List<String> actualKeys = sortedArray;

        assertEquals("Keys should be sorted", expectedKeys, actualKeys);
    }
    
    // Count
    @Test
    public void testEmptyFile() {
        ArrayList<String> fileLines = new ArrayList<>();
        Pair result = CountYourWords.count(fileLines);

        assertEquals("Total words should be 0", 0, result.getFirst());
        assertTrue("Word counts map should be empty", result.getSecond().isEmpty());
    }

    // Test with a single line
    @Test
    public void testSingleLine() {
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("Hello world");

        Pair result = CountYourWords.count(fileLines);

        assertEquals("Total words should be 2", 2, result.getFirst());

        HashMap<String, Integer> expectedCounts = new HashMap<>();
        expectedCounts.put("hello", 1);
        expectedCounts.put("world", 1);

        assertEquals("Word counts should match expected counts", expectedCounts, result.getSecond());
    }

    // Test with multiple lines
    @Test
    public void testMultipleLines() {
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("Hello world");
        fileLines.add("This is a test.");
        fileLines.add("World of Java!");

        Pair result = CountYourWords.count(fileLines);

        assertEquals("Total words should be 9", 9, result.getFirst());

        HashMap<String, Integer> expectedCounts = new HashMap<>();
        expectedCounts.put("hello", 1);
        expectedCounts.put("world", 2);
        expectedCounts.put("this", 1);
        expectedCounts.put("is", 1);
        expectedCounts.put("a", 1);
        expectedCounts.put("test", 1);
        expectedCounts.put("of", 1);
        expectedCounts.put("java", 1);

        assertEquals("Word counts should match expected counts", expectedCounts, result.getSecond());
    }

    // Test with words of varying cases
    @Test
    public void testCaseInsensitivity() {
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("Apple apple APPLE ApPlE");

        Pair result = CountYourWords.count(fileLines);

        assertEquals("Total words should be 4", 4, result.getFirst());

        HashMap<String, Integer> expectedCounts = new HashMap<>();
        expectedCounts.put("apple", 4);

        assertEquals("Words should be counted in a case-insensitive manner", expectedCounts, result.getSecond());
    }

    // Test with punctuation
    @Test
    public void testPunctuation() {
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("Hello, world!! Welcome to Java.");

        Pair result = CountYourWords.count(fileLines);

        assertEquals("Total words should be 5", 5, result.getFirst());

        HashMap<String, Integer> expectedCounts = new HashMap<>();
        expectedCounts.put("hello", 1);
        expectedCounts.put("world", 1);
        expectedCounts.put("welcome", 1);
        expectedCounts.put("to", 1);
        expectedCounts.put("java", 1);

        assertEquals("Words should be counted correctly despite punctuation", expectedCounts, result.getSecond());
    }

    // Test with numbers and symbols
    @Test
    public void testNumbersAndSymbols() {
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("Numbers 123 and symbols #!$");

        Pair result = CountYourWords.count(fileLines);

        assertEquals("Total words should be 3", 3, result.getFirst());

        HashMap<String, Integer> expectedCounts = new HashMap<>();
        expectedCounts.put("numbers", 1);
        expectedCounts.put("and", 1);
        expectedCounts.put("symbols", 1);

        assertTrue("Word counts should ignore numbers and symbols", !(result.getSecond().containsKey("123") && result.getSecond().containsKey("#!$")));
    }

    // Test with empty and whitespace-only lines
    @Test
    public void testEmptyAndWhitespaceLines() {
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("");
        fileLines.add("   ");
        fileLines.add("\t\n");

        Pair result = CountYourWords.count(fileLines);

        assertEquals("Total words should be 0", 0, result.getFirst());
        assertTrue("Word counts map should be empty", result.getSecond().isEmpty());
    }

    // Test with null input
    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        CountYourWords.count(null);
    }

    // Test with lines containing null
    @Test
    public void testNullLines() {
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add(null);
        fileLines.add("Test line");
        fileLines.add(null);

        Pair result = CountYourWords.count(fileLines);

        assertEquals("Total words should be 2", 2, result.getFirst());

        HashMap<String, Integer> expectedCounts = new HashMap<>();
        expectedCounts.put("test", 1);
        expectedCounts.put("line", 1);

        assertEquals("Words from null lines should be skipped", expectedCounts, result.getSecond());
    }

    // Read Text
    // Test reading a non-existent file
    @Test(expected = FileNotFoundException.class)
    public void testFileNotFound() throws Exception {
        String nonExistentFilePath = "nonExistentFile.txt";

        CountYourWords.readFile(nonExistentFilePath);
    }

    // Test reading an empty file
    @Test
    public void testReadEmptyFile() throws Exception {
        ArrayList<String> fileLines = CountYourWords.readFile("./src/test/textTests/emptyFile.txt");

        // Assert
        assertNotNull("File lines should not be null", fileLines);
        assertEquals("File should contain 0 lines", 0, fileLines.size());
    }

    // Test reading a valid file with known content
    @Test
    public void testReadValidFile() throws Exception {
        ArrayList<String> fileLines = CountYourWords.readFile("./src/test/textTests/validFile.txt");

        // Assert
        assertNotNull("File lines should not be null", fileLines);
        assertEquals("File should contain 3 lines", 3, fileLines.size());
        assertEquals("First line", fileLines.get(0));
        assertEquals("Second line", fileLines.get(1));
        assertEquals("Third line", fileLines.get(2));
    }

    @Test
    public void fileNotPeriodExample() throws Exception {
        ArrayList<String> fileLines = CountYourWords.readFile("./src/test/textTests/nonPeriodFile.txt");

        // Assert
        assertNotNull("File lines should not be null", fileLines);
        assertEquals("File should contain 1 lines", 1, fileLines.size());
        assertEquals("So this won't ! Split Lines", fileLines.get(0));
    }
    
    @Test
    public void finalTestWithExample() throws Exception {
        ArrayList<String> fileLines = CountYourWords.readFile("./src/test/textTests/exampleFile.txt");

        // Assert
        assertNotNull("File lines should not be null", fileLines);
        assertEquals("File should contain 7 lines", 7, fileLines.size());
        assertEquals("", fileLines.get(0));
        assertEquals("", fileLines.get(1));
        assertEquals("", fileLines.get(2));
        assertEquals("", fileLines.get(3));
        assertEquals("The big brown fox number 4 jumped over the lazy dog", fileLines.get(4));
        assertEquals("THE BIG BROWN FOX JUMPED OVER THE LAZY DOG", fileLines.get(5));
        assertEquals("The Big Brown Fox 123 !!", fileLines.get(6));
    }
}