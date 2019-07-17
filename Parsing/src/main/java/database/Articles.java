package database;

import entities.Article;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Articles {
    public static void addArticle(Article article) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO articles(author, topic, content, date_time)" +
                "VALUES(?,?,?,?)";

        PreparedStatement statement = DBHandler.getConnection().prepareStatement(insert);

        statement.setString(1, article.getAuthor());
        statement.setString(2, article.getTopic());
        statement.setString(3, article.getContent().toString());
        statement.setString(4, article.getDateTime());

        statement.executeUpdate();
    }

    public static ArrayList<Article> getAll() throws SQLException {
        ArrayList<Article> articles = new ArrayList<Article>();

        String select = "SELECT * FROM articles";
        Statement statement = DBHandler.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            Article article = new Article();
            article.setAuthor(resultSet.getString(2));
            article.setDateTime(resultSet.getString(5));
            article.setTopic(resultSet.getString(3));
            article.setContent(new StringBuffer(resultSet.getString(4)));
            articles.add(article);
        }

        return articles;
    }
}
