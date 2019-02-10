package com.company.service;

import com.company.DBConnection;
import com.company.dto.Dish;
import org.springframework.stereotype.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MenuService {
    public MenuService() {
    }

    public List<Dish> getMenu(){
        DBConnection dBConnection = new DBConnection();
        Statement statement = dBConnection.dbConnection();
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
