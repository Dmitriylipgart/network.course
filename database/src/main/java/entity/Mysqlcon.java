package entity;
import com.mysql.cj.jdbc.*;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;


public class Mysqlcon {
    public static final String URL = "jdbc:mysql://localhost:3306/files?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "";

    public Connection getConnection() {
        createConnection();
        return connection;
    }

    Connection connection = null;

    private void createConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private Statement getStatement(){
        Statement statement = null;
        createConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public void readAll(){
        String sql = "Select * from login";
        Statement statement = getStatement();

        try {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("login"));
                System.out.println(resultSet.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
