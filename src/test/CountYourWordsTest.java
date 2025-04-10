package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import main.CountYourWords;

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
        
    // Count the words in a list of lines
    
    // Read from file
}
