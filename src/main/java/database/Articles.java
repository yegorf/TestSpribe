package database;

import entities.Article;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Articles {
    public static void addArticle(Article article) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO articles(author, topic, content, date_time)" +
                "VALUES(?,?,?,?)";

        PreparedStatement statement = DBHandler.getConnection().prepareStatement(insert);

        statement.setString(1, article.getAuthor());
        statement.setString(2, article.getTopic());
        statement.setString(3, article.getContent());
        statement.setString(4, article.getDateTime());

        statement.executeUpdate();
    }
}
