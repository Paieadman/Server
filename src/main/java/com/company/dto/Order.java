package com.company.dto;

import java.io.Serializable;

public class Order implements Serializable {
    private int id;
    private int userid;
    private String dateorder;
    private int idstatus;
    private String dishes;

    public Order(){
    }

    public Order(int id, int userid, String dateorder, int idstatus, String dishes) {
        this.id = id;
        this.userid = userid;
        this.dateorder = dateorder;
        this.idstatus = idstatus;
        this.dishes = dishes;
    }

    public Order(int userid, String dateorder, int idstatus, String dishes) {
        this.userid = userid;
        this.dateorder = dateorder;
        this.idstatus = idstatus;
        this.dishes = dishes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDateorder() {
        return dateorder;
    }

    public void setDateorder(String dateorder) {
        this.dateorder = dateorder;
    }

    public int getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(int idstatus) {
        this.idstatus = idstatus;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userid=" + userid +
                ", dateorder='" + dateorder + '\'' +
                ", idstatus=" + idstatus +
                ", dishes='" + dishes + '\'' +
                '}';
    }
}
