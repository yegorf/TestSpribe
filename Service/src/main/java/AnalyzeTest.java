import analyze.ArticleAnalyzer;
import analyze.ReadingThread;
import db.Articles;
import entities.Article;

import java.sql.SQLException;
import java.util.ArrayList;

public class AnalyzeTest {
    public static void main(String[] args) throws SQLException, InterruptedException {
        ArrayList<Article> articles = Articles.getAll();
        ArrayList<Thread> threads = new ArrayList<>();

        for (Article article : articles) {
            threads.add(new Thread(new ReadingThread(article.getContent().toString())));
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }

        String word = "на"; //Write any word to get info
        System.out.println("Count of " + word + " = " + ArticleAnalyzer.getCount(word));
    }
}
