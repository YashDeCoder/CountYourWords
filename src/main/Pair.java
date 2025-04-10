package main;
import java.util.HashMap;

public final class Pair {
    private final int totalCount;
    private final HashMap<String, Integer> wordCounts;
    
    public Pair(int first, HashMap<String, Integer> second) {
        this.totalCount = first;
        this.wordCounts = second;
    }

    public int getFirst() {
        return totalCount;
    }

    public HashMap<String, Integer> getSecond() {
        return wordCounts;
    }
}
