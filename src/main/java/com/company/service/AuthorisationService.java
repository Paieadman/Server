package com.company.service;

import com.company.ConnectionFactory;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class AuthorisationService {
    ConnectionFactory connectionFactory;
    public AuthorisationService(){

    }

    public String authorisation(String login, String pass){
        Connection connection = connectionFactory.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String select = "select userpass from userreg where userlogin = '"+login+"'";
        System.out.println(select);
        try {
            ResultSet rs = statement.executeQuery(select);
            rs.next();
            if(rs.getString("userpass").equals(pass)){
                return "Authorisation completed";
            } else {
                return "Wrong pass";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return "Wrong info";
    }

}
