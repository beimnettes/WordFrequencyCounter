import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder textInput = new StringBuilder();
        
        System.out.println("Enter text (type 'exit' on a new line to finish):");

        // Reading multiple lines of input until "exit" is entered
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            textInput.append(line).append(" ");
        }

        // Process the input text
        String text = textInput.toString().toLowerCase();
        String[] words = text.split("\\s+");

        // Calculate word frequency
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", ""); // Removing punctuation
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        // Sort by words alphabetically using TreeMap
        TreeMap<String, Integer> sortedWordCountMap = new TreeMap<>(wordCountMap);

        // Display the word frequencies
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : sortedWordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}
