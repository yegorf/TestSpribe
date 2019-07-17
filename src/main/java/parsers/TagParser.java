package parsers;

import entities.Article;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class TagParser {
    private ParserStrategy parserStrategy;

    public void parse(String text, Article article) {
        parserStrategy.parse(text, article);
    }
}
