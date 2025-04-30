package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public void createDataBaseConnection() throws ClassNotFoundException, SQLException {
        String databaseURL = "jdbc:mysql://localhost:3306/demo_test";
        String user = "root";
        String password = "root";

        // Load the MySQL JDBC driver and establish connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to Database");
        connection = DriverManager.getConnection(databaseURL, user, password);

        // Check if the connection is successful
        if (connection == null) {
            System.out.println("Database Connection Failed");
        }else {
            System.out.println("Database Connection Successful");
        }
    }

}
