package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {

    Connection connection;

    public Connection getConnection() {
        createConnection();
        return connection;
    }

    public Statement getStatement() {
        Statement statement=null;
        try  {

            createConnection();
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30
            System.out.println("Connect to database successful");
        } catch (
                SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return statement;
    }

    public void createConnection()
    {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:E:\\Downloads\\java ee\\network\\database\\src\\main\\resources\\Test.db");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void closeConnection()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}