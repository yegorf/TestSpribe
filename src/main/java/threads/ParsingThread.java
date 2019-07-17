package threads;


import database.Articles;
import entities.Article;
import parsers.UrlParser;
import parsing.MainParser;

import java.io.IOException;
import java.sql.SQLException;

public class ParsingThread implements Runnable {
    private String url;

    public ParsingThread(String heading) throws IOException {
        this.url = UrlParser.parseArticleUrl("https://ain.ua/tag/" + heading);
    }

    public void run() {
        System.out.println("Started " + Thread.currentThread().getName() + " article: " + url);
        Article article = null;
        try {
            article = new MainParser().parseCategoryLastTopic(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ended");
        System.out.println(article);
        try {
            assert article != null;
            Articles.addArticle(article);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
