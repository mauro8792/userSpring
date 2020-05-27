package com.example.UsersSpringBoot.Controllers;

import com.example.UsersSpringBoot.Models.User;
import com.example.UsersSpringBoot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public List getAllUsers(){
        List<User> usersAlls = userService.getAllUsers();
        return usersAlls;
    }
    @GetMapping(value = "/{id}")
    public Optional<User> getById(@PathVariable("id") Long id){
        Optional<User> user1 = userService.getById(id);
        return user1;
    }
    //url: jdbc:mysql://localhost:3306/usersspring?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
}
