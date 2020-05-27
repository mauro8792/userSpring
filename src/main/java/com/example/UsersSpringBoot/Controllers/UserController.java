package com.example.UsersSpringBoot.Controllers;

import com.example.UsersSpringBoot.Models.User;
import com.example.UsersSpringBoot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List getAllUsers(){
        List<User> usersAlls = userService.getAllUsers();
        return usersAlls;
    }
}
