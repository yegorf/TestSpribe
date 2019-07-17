package parsers;

import entities.Article;

public class PostDateParser implements ParserStrategy {
    @Override
    public void parse(String text, Article article) {
        String[] strings = text.split(" ");
        article.setDateTime(strings[0] + " " + strings[1] + " " + strings[2] + " " + strings[3]);
        article.setViews(strings[4]);
        article.setAuthor(strings[5] + " " + strings[6]);
    }
}
