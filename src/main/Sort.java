package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
        /* Function to sort array using insertion sort 
         * 
         * @param String[] containing words that need to be sorted
         * @return ArrayList<String> sortedArray
        */
        public static ArrayList<String> insertionSort(String arr[]) {
            if (arr == null) throw new IllegalArgumentException();
            
            int n = arr.length;

            for (int i = 1; i < n; ++i) {
                String key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j].compareTo(key) > 0) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }

            return new ArrayList<>(Arrays.asList(arr));
        }
}
