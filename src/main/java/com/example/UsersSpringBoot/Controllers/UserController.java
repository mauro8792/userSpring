package com.example.UsersSpringBoot.Controllers;

import com.example.UsersSpringBoot.Models.User;
import com.example.UsersSpringBoot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public List getAllUsers() {
        List<User> usersAlls = userService.getAllUsers();
        return usersAlls;
    }

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable("id") Long id) {
        User user1 = this.userService.getById(id);
        return user1;
    }

    @PutMapping(value = "/{id}")
    public Boolean modifyUser(@RequestBody User user1, @PathVariable Long id) {
        boolean rtn = false;
        User userOld = this.userService.getById(id);
        System.out.println(userOld.getName());
        if (userOld.equals(null))
            rtn = this.userService.updateUser(user1);

        return rtn;
    }
}
