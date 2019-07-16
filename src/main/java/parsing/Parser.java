package parsing;

import entities.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Parser {
    private Document document;

    public Parser(String url) throws IOException {
        document = Jsoup.connect(url).userAgent("Mozilla").get();
    }

    public void parseUrl() {
        Element dateElement = document.select("a").get(0);
        String date = dateElement.text();
        System.out.println("URL: " + date);
    }

    public Article parseAll() {
        Article article = new Article();
        article.setAuthor(parseAuthor());
        article.setDateTime(parseDateTime());
        article.setTopic(parseTopic());
        article.setContent(parseContent());

        return article;
    }

    private String parseDateTime() {
        Element dateElement = document.select("div.post-date").get(0);
        return dateElement.text();
    }

    private String parseAuthor() {
        Element authorElement = document.select("span.author_name").get(0);
        return authorElement.text();
    }

    private String parseTopic() {
        Element authorElement = document.select("h1").get(0);
        return authorElement.text();
    }

    private String parseContent() {
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        Element contentElement;
        while (!document.select("p").get(i).text().equals("\u00A0")) {
            contentElement = document.select("p").get(i);
            String content = contentElement.text();
            buffer.append(content);
            i++;
        }
        return buffer.toString();
    }
}
