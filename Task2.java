import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task2{
    public static void main(String[] args) {
        String inputText = getInput();

        String[] words = inputText.split("[\\s.,;?!]+");

        int wordCount = 0;

        for (String word : words) {
            if (!isStopWord(word)) {
                wordCount++;
            }
        }

        System.out.println("Total word count: " + wordCount);

        displayWordStatistics(words);
    }

    private static String getInput() {
        return "This is a sample text. Sample text can have repeated words. Repeated words are counted.";
    }

    private static boolean isStopWord(String word) {
        Set<String> stopWords = new HashSet<>(Arrays.asList("is", "a", "the", "can", "have", "are"));

        return stopWords.contains(word.toLowerCase());
    }

    private static void displayWordStatistics(String[] words) {
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.println("Number of unique words: " + uniqueWords.size());

        System.out.println("Word frequency:");
        for (String word : uniqueWords) {
            int frequency = (int) Arrays.stream(words).filter(w -> w.equals(word)).count();
            System.out.println(word + ": " + frequency);
        }
    }
}
