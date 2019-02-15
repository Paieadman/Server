package com.company;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

//import com.mysql.fabric.jdbc.FabricMySQLDriver;

public class DBConnection {
    private Connection connection;

    public DBConnection(){
        String URL = "jdbc:mysql://127.0.0.1:3306/kafe?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";/*?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";*/
        String user = "root";
        String pass = "root";
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            this.connection = DriverManager.getConnection(URL, user, pass);
            System.out.println("connection constructor");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection DConnection(){
        String URL = "jdbc:mysql://127.0.0.1:3306/kafe?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";/*?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";*/
        String user = "root";
        String pass = "root";
        Connection connection;
        try{
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, user, pass);
            if(!connection.isClosed()){
                System.out.println("connection opens");
            } else {
                System.out.println("shit");
            }
            return connection;
        }   catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public Connection getConnection(){
        return this.connection!=null?this.connection: DConnection();
    }
}
