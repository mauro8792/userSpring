package com.example.UsersSpringBoot.Models;

public class User {
    private Integer id;
    private String name;
    private String user_name;

    public User() {
    }

    public User(String name, String user_name) {
        this.name = name;
        this.user_name = user_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
