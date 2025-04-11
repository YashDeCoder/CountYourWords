package main;
import java.io.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the Path : ");
        
        // Reading File name
        String path = "";
        try {
            path = br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ArrayList<String> fileLines = CountYourWords.readFile(path);
        Pair wordTotalCount = CountYourWords.count(fileLines);
        ArrayList<String> finaList = CountYourWords.sort(wordTotalCount.getSecond());
        System.out.printf("Number of words: %d\n", wordTotalCount.getFirst());
        for (String line: finaList) {
            System.out.println(line);
        }
    }
}
