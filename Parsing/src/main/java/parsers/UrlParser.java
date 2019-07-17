package parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class UrlParser {
    public static String parseArticleUrl(String headingUrl) throws IOException {
        Document document = Jsoup.connect(headingUrl).userAgent("Mozilla").get();
        return document.select("a.post-link").attr("href");
    }
}
