package analyze;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReadingThread implements Runnable {
    private String text;

    @Override
    public void run() {
        String[] words = text.split(" ");
        for (String word : words) {
            ArticleAnalyzer.analyze(word);
        }
    }
}
