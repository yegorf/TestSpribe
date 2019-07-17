package parsing;

import entities.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parsers.ContentParser;
import parsers.PostDateParser;
import parsers.TagParser;
import parsers.TopicParser;

import java.io.IOException;

public class MainParser {

    public synchronized Article parseCategoryLastTopic(String url) throws IOException {
        Document document = Jsoup.connect(url).userAgent("Mozilla").get();

        Element htmlElement = document.select("div.post-content").get(0);
        Elements allElements = htmlElement.children();
        Article article = new Article();
        TagParser parser = new TagParser();

        for (int i = 0; i < allElements.size() - 2; i++) {
            String name;
            if (!allElements.get(i).className().equals("")) {
                name = allElements.get(i).tagName() + "." + allElements.get(i).className();
            } else {
                name = allElements.get(i).tagName();
            }

            chooseStrategy(name, parser);
            parser.parse(allElements.get(i).text(), article);
        }

        return article;
    }

    private void chooseStrategy(String tagName, TagParser parser) {
        switch (tagName) {
            case TagType.H1:
                parser.setParserStrategy(new TopicParser());
                break;
            case TagType.POST_DATA:
                parser.setParserStrategy(new PostDateParser());
                break;
            default:
                parser.setParserStrategy(new ContentParser());
                break;
        }
    }

}
