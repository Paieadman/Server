package com.company.service;

import com.company.DBConnection;
import org.springframework.stereotype.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class RegistrationService {
    public RegistrationService(){

    }

    public String registration(String login, String pass){
        DBConnection dBConnection = new DBConnection();
        Statement statement = dBConnection.dbConnection();
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
