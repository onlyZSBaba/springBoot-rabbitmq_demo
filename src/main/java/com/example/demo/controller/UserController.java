package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/6/30
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findUser")
    public String findUser(@RequestParam("name") String name){

        return userService.findUser(name);
    }
}
