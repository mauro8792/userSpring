package com.example.UsersSpringBoot.Repository;

import com.example.UsersSpringBoot.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DaoUser   {

    @Autowired
    private JdbcTemplate jdbc;

    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        users =jdbc.query("select * from users", new BeanPropertyRowMapper(User.class));
        return users;
    }

    public Optional<User> findById(Long id){
        return jdbc.queryForObject("select * from users where id = ?",
                new Object[]{id},
                (rs,rowNum)->
                    Optional.of(new User(
                            (long) rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("username")
                    ))
        );
    }

    public int updateUser(User user) {
        return jdbc.update(
                "update users set name = ?, username = ? where id = ?",
                user.getName(), user.getUserName(), user.getId());
    }

}
