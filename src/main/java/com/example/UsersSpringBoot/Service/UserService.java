package com.example.UsersSpringBoot.Service;

import com.example.UsersSpringBoot.Models.User;
import com.example.UsersSpringBoot.Repository.DaoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    @Autowired
    private DaoUser daoUser;

    public UserService(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    public List getAllUsers(){
        List<User> users=null;
        try {
            users=this.daoUser.findAll();
            System.out.println(users);
        }catch (Exception e){
            e.getMessage();
        }
        return users;
    }
    public User getById(Long id){
        User user = null;
        try {
            user= this.daoUser.findById(id);

        }catch ( Exception  e){
            e.getMessage();
        }
        return user;
    }
    public Boolean updateUser(User us){
        Boolean modi = false;
        if (this.daoUser.updateUser(us)==1)
            modi = true;
        return modi;

    }
}
