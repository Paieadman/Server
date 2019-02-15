package com.company.service;
import com.company.DBConnection;
import com.company.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class OrderService {
    public OrderService(){
        dbconnection = new DBConnection();
    }
    DBConnection dbconnection;

    public List<Order> getOrders(){

        Connection connection = dbconnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Order> lst = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("select * from kafe.order where idstatus = 1");
            while (rs.next()){
                int id = rs.getInt("idorder");
                int user = rs.getInt("iduser");
                String date = rs.getDate("dateorder").toString();
                String dishes = rs.getString("orderList");
                lst.add(new Order(id, user,date,1,dishes));
            }
            return lst;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public Order addOrder(Order order) {
        System.out.println(order.toString());
        Connection connection = dbconnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String str = "" +
                    "insert into kafe.order (iduser,dateorder,idstatus,orderList) values " +
                    "("+2+","+"'2000-11-11 3:12:11'"+","+"1"+","+"'"+order.getDishes()+"'"+")";
            System.out.println(str);
            statement.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Order(0, 0,"2",0, order.getDishes());
    }

    public String removeOrder(int id){
        Connection connection = dbconnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String str = "delete from kafe.orders where idorder="+id;
            statement.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "deleted";
    }

    public String updateOrder(int id, String value){
        Connection connection = dbconnection.getConnection();
        try{
            Statement statement = connection.createStatement();
            String str = "update kafe.order set "
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
