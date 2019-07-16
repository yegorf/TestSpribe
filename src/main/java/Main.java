import analysis.ArticleAnalyzer;
import database.Articles;
import entities.Article;
import parsing.Parser;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, IOException {
        System.out.println("Started\n");

//        Thread thread1 = new Thread(new ParsingThread("https://ain.ua/2019/07/12/zelenyj-tarif-vernuli-chto-eto-znachit/"), "1");
//        Thread thread2 = new Thread(new ParsingThread("https://ain.ua/2019/07/04/liki24-privlekli-million-dollarov/"), "2");
//        Thread thread3 = new Thread(new ParsingThread("https://ain.ua/2019/07/15/krokodily-kotorye-ne-puskayut-vash-biznes-razvivatsya-opyt-studii-vintage/"), "3");
//        Thread thread4 = new Thread(new ParsingThread("https://ain.ua/2019/07/11/kakim-budet-spaces-na-majdane/"), "4");
//        Thread thread5 = new Thread(new ParsingThread("https://ain.ua/2019/07/10/kak-oformit-dekretnuju-vyplatu-fop/"), "5");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();

//        for(String s : new Headings().getAllHeadings()) {
//            new Parser("https://ain.ua/tag/" + s).parseUrl();
//
//        }
        Parser parser = new Parser("https://ain.ua/2019/07/12/zelenyj-tarif-vernuli-chto-eto-znachit/");
        Article article = parser.parseAll();
        System.out.println(article);
        Articles.addArticle(article);

        String word = "на";
        int count = ArticleAnalyzer.analyze(article.getContent(), word);
        System.out.println("Количество повторений слова " + "\"" + word + "\" в статье " + "\"" + article.getTopic() + "\" = " + count);
    }
}
