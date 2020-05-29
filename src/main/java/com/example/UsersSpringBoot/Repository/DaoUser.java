package com.example.UsersSpringBoot.Repository;

import com.example.UsersSpringBoot.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoUser   {

    @Autowired
    private JdbcTemplate jdbc;

    public DaoUser(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        users =jdbc.query("select * from users", new BeanPropertyRowMapper(User.class));
        return users;
    }

    public User findById(Long id){
        return jdbc.queryForObject("select * from users where id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    public int updateUser(User user) {
        return jdbc.update(
                "update users set name = ?, username = ? where id = ?",
                user.getName(), user.getUserName(), user.getId());
    }

    public int saveUser(User user){
        return jdbc.update("insert into users (?,?) values (?,?)",
                user.getName(),user.getUserName());
    }

    public int delete(Long id) {
        return jdbc.update("DELETE from country where id = ?",id);
    }

}
