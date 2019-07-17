package analyze;

import java.util.HashMap;

public class ArticleAnalyzer {
    private static HashMap<String, Integer> words = new HashMap<>();

    public static void analyze(String word) {
        if (words.containsKey(word)) {
            words.put(word, words.get(word) + 1);
        } else {
            words.put(word, 0);
        }
    }

    public static int getCount(String word) {
        if (words.containsKey(word)) {
            return words.get(word);
        } else {
            return 0;
        }
    }
}

