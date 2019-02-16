package com.company;

import java.sql.*;

public class ConnectionFactory {
    private static Connection connection;
    private static String URL = "jdbc:mysql://127.0.0.1:3306/kafe?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";/*?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";*/
    private static String USER = "root";
    private static String PASSWORD = "root";

    public static Connection getConnection(){
        if(connection != null){
            return connection;
        } else {
            try {
                Driver driver = new com.mysql.jdbc.Driver();
                DriverManager.registerDriver(driver);
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
