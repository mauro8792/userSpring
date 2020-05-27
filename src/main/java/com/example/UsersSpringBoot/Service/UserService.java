package com.example.UsersSpringBoot.Service;

import com.example.UsersSpringBoot.Models.User;
import com.example.UsersSpringBoot.Repository.DaoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<User> getById(Long id){
        User user = new User();
        return this.daoUser.findById(id);

    }
}
