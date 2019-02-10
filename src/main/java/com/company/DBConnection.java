package com.company;

import java.sql.*;

//import com.mysql.fabric.jdbc.FabricMySQLDriver;

public class DBConnection {


    public Statement dbConnection(){
        String URL = "jdbc:mysql://127.0.0.1:3306/kafe?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";/*?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";*/
        String user = "root";
        String pass = "root";
        Connection connection;

        try{
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, user, pass);
            Statement statement = connection.createStatement();
            if(!connection.isClosed()){
                System.out.println("connection opens");
            } else {
                System.out.println("shit");
            }
            return statement;
        }   catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
