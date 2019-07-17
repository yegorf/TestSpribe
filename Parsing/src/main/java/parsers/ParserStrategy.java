package parsers;

import entities.Article;

public interface ParserStrategy {
    void parse(String text, Article article);
}
