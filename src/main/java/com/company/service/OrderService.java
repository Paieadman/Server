package com.company.service;
import com.company.DBConnection;
import com.company.dto.Order;
import org.springframework.stereotype.Controller;

import java.sql.Statement;
import java.util.List;

@Controller
public class OrderService {
    public OrderService(){}

    public List<Order> getOrders(){
        DBConnection dbConnection = new DBConnection();
        Statement statement = dbConnection.dbConnection();
        statement.executeQuery("select ")
    }
}
