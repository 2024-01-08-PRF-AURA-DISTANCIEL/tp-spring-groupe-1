package fr.maboite.tp_article.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseJdbcMain {

    public static void main(String[] args) {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "");
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ventes_articles",
                connectionProps)) {
            DataBaseJdbcMain databaseJdbcMain = new DataBaseJdbcMain();
            databaseJdbcMain.launchQueries(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Could not connect to database ", e);
        }

    }
    //private String selectQuery;

    private void launchQueries(Connection connection) {
      throw new UnsupportedOperationException("Unimplemented method 'launchQueries'");
    }
}
