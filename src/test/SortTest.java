package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import main.CountYourWords;
import main.Sort;

public class SortTest {
    // Insertion Sort
    @Test
    public void testInsertionSortWithEmptyArray() {
        String[] data = {};
        String[] expected = {};

        ArrayList<String> result = Sort.insertionSort(data);

        assertEquals("Sorting an empty array should return an empty list.", Arrays.asList(expected), result);
    }

    @Test
    public void testInsertionSortWithUnsortedArray() {
        String[] data = { "banana", "apple", "orange", "grape", "cherry" };
        String[] expected = { "apple", "banana", "cherry", "grape", "orange" };

        ArrayList<String> result = Sort.insertionSort(data);

        assertEquals("The sorted list should match the expected list.", Arrays.asList(expected), result);
    }

    @Test
    public void testInsertionSortWithAlreadySortedArray() {
        String[] data = { "apple", "banana", "cherry", "grape", "orange" };
        String[] expected = { "apple", "banana", "cherry", "grape", "orange" };

        ArrayList<String> result = Sort.insertionSort(data);

        assertEquals("The sorted list should remain unchanged.", Arrays.asList(expected), result);
    }
    
    @Test
    public void testInsertionSortWithSingleElement() {
        String[] data = { "apple" };
        String[] expected = { "apple" };

        ArrayList<String> result = Sort.insertionSort(data);

        assertEquals("Sorting a single-element array should return the same element.", Arrays.asList(expected), result);
    }

    @Test
    public void testInsertionSortWithDuplicates() {
        String[] data = { "apple", "banana", "apple", "cherry", "banana" };
        String[] expected = { "apple", "apple", "banana", "banana", "cherry" };

        ArrayList<String> result = Sort.insertionSort(data);

        assertEquals("Duplicates should be sorted and appear consecutively.", Arrays.asList(expected), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        Sort.insertionSort(null);
    }
}
