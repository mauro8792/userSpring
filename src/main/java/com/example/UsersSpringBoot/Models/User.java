package com.example.UsersSpringBoot.Models;

public class User {
    private Long id;
    private String name;
    private String user_name;

    public User() {
    }

    public User(Long id,String name, String user_name) {
        this.id = id;
        this.name = name;
        this.user_name = user_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
