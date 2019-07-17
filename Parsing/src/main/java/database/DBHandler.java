package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {

    public static synchronized Connection getConnection() throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/parsing?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Connection connection = DriverManager.getConnection(connectionUrl, DBConfig.NAME, DBConfig.PASSWORD);
        return connection;
    }
}
