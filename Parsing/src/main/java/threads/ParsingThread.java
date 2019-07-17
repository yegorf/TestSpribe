package threads;


import database.Articles;
import entities.Article;
import lombok.Data;
import parsers.UrlParser;
import parsing.MainParser;

import java.io.IOException;
import java.sql.SQLException;

@Data
public class ParsingThread implements Runnable {
    private String url;

    public ParsingThread(String heading) throws IOException {
        this.url = UrlParser.parseArticleUrl("https://ain.ua/tag/" + heading);
    }

    public void run() {
        Article article = null;
        try {
            article = new MainParser().parseCategoryLastTopic(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert article != null;
            Articles.addArticle(article);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(article);
    }
}
