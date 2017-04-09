package db.mysql;

import java.sql.*;

/**
 * Created by mihail on 09.04.17.
 */
public abstract class MySqlConnect {
    protected Connection connection;
    protected Statement statement;
    protected ResultSet resultSet;

    protected Connection connectDB() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8",
                "testUser", "qwerty");
    }

    protected void closeConnection() throws SQLException {
        if (connection != null)
            connection.close();
        if (statement != null)
            statement.close();
        if (resultSet != null)
            resultSet.close();
    }
}
