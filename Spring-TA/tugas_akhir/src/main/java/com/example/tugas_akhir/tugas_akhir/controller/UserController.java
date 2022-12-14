package com.example.tugas_akhir.tugas_akhir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tugas_akhir.tugas_akhir.model.User;
import com.example.tugas_akhir.tugas_akhir.service.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/user")
public class UserController {

    @Autowired IUserService userService;

    @PostMapping("/insert")
    public User insertUser(@RequestBody User user){
        return userService.insertUser(user);
    } 
    
    @PostMapping("/Login")
        public User Login(@RequestBody User user ){
            return userService.login(user);
        }
    
}

