package parsers;

import entities.Article;

public class ContentParser implements ParserStrategy {
    @Override
    public void parse(String text, Article article) {
        article.addContent(text);
    }
}
