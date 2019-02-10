package com.company.service;

import com.company.DBConnection;
import org.springframework.stereotype.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class AuthorisationService {
    public AuthorisationService(){

    }

    public String authorisation(String login, String pass){
        DBConnection dBConnection = new DBConnection();
        Statement statement = dBConnection.dbConnection();
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
