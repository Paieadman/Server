package com.company.service;
import com.company.ConnectionFactory;
import com.company.dto.Order;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class OrderService {
    private Connection dbconnection;

    public OrderService(){
        dbconnection = ConnectionFactory.getConnection();
    }

    public List<Order> getOrders(){
        Statement statement = null;
        try {
            statement = dbconnection.createStatement();
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
        try {
            Statement statement = dbconnection.createStatement();
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
        try {
            Statement statement = dbconnection.createStatement();
            String str = "delete from kafe.orders where idorder="+id;
            statement.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "deleted";
    }

    public String updateOrder(int id, String value, String pos){
        try{
            Statement statement = dbconnection.createStatement();
            switch (pos){
                case "1": { pos="idorder"; break;}
                case "2": { pos="iduser"; break;}
                case "3": { pos="dateorder"; break;}
                case "4": { pos="idstatus"; break;}
                case "5": { pos="orderList"; break;}
            }
            String str = "update kafe.order set "+pos+"="+value+ " where id="+id;
            return "ok";
        } catch (SQLException e){
            e.printStackTrace();
        }
        return "not ok";
    }
}
