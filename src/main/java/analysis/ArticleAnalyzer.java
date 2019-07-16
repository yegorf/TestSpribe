package analysis;

public class ArticleAnalyzer {
    public static int analyze(String text, String word) {
        int count = 0;
        String[] words = text.split(" ");
        for (String w : words) {
            if (w.equalsIgnoreCase(word) || w.equalsIgnoreCase(word + ".")) {
                count ++;
            }
        }
        return count;
    }
}

