package com.company.dto;

public class User {
    private int id;
    private String name;
    private int idrole;

    public User(int id, String name, int idrole) {
        this.id = id;
        this.name = name;
        this.idrole = idrole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }
}
