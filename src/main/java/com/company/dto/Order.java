package com.company.dto;

public class Order {
    private int id;
    private int userid;
    private String dateorder;
    private int idstatus;
    private int iddisheslist;
    private int cost;

    public Order(int id, int userid, String dateorder, int idstatus, int iddisheslist, int cost) {
        this.id = id;
        this.userid = userid;
        this.dateorder = dateorder;
        this.idstatus = idstatus;
        this.iddisheslist = iddisheslist;
        this.cost = cost;
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

    public int getIddisheslist() {
        return iddisheslist;
    }

    public void setIddisheslist(int iddisheslist) {
        this.iddisheslist = iddisheslist;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
