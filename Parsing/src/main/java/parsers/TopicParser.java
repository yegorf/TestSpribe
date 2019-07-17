package parsers;

import entities.Article;

public class TopicParser implements ParserStrategy {
    @Override
    public void parse(String text, Article article) {
        article.setTopic(text);
    }
}
