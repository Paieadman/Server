package com.company.service;

import com.company.ConnectionFactory;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class RegistrationService {
    ConnectionFactory connectionFactory;
    public RegistrationService(){

    }

    public String registration(String login, String pass){
        Connection connection = connectionFactory.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String select = "select userlogin from userreg where userlogin = '"+login+"'";
        try {
            ResultSet rs = statement.executeQuery(select);
            if(!rs.isBeforeFirst()){
                statement.execute("insert into userreg (userlogin, userpass) values ('"+login+"','"+pass+"')");
                return "registration successful";
            }
            else {
                return "login reserved";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "wrong try";
    }
}
