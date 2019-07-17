package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class Headings {
    public static HashSet<String> getAllHeadings() throws SQLException, ClassNotFoundException {
        HashSet<String> headings = new HashSet<String>();
        String select = "SELECT * FROM headings";

        Statement statement = DBHandler.getConnection().createStatement();
        ResultSet resSet = statement.executeQuery(select);

        while (resSet.next()) {
            headings.add(resSet.getString(2));
        }
        return headings;
    }
}
