package com.example.lost_found.Controller;

import com.example.lost_found.DTO.LoginRequest;
import com.example.lost_found.Entity.User;
import com.example.lost_found.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody LoginRequest loginRequest){
        return userService.Login(loginRequest);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/id/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }
}
