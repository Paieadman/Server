package com.company.service;

import com.company.DBConnection;
import com.company.dto.Dish;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MenuService {
    DBConnection dbConnection;
    public MenuService() {
        dbConnection = new DBConnection();
    }

    public List<Dish> getMenu(){
        Connection connection = dbConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM DISH");
            List<Dish> lst = new ArrayList<Dish>();
            while (rs.next()){
                int first = rs.getInt("iddish");
                String second = rs.getString("name");
                int third = rs.getInt("cost");
                lst.add(new Dish(first,second,third));
            }
            return lst;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
