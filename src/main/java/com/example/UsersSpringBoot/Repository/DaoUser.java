package com.example.UsersSpringBoot.Repository;

import com.example.UsersSpringBoot.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoUser   {

    @Autowired
    private JdbcTemplate jdbc;

    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        users =jdbc.query("select * from users", new BeanPropertyRowMapper(User.class));

        return users;
    }

}
