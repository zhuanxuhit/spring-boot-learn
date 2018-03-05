package com.babyfs.stage1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${com.babyfs.name}")
    String name;

    @Value("${com.babyfs.say}")
    String say;

    @GetMapping("/")
    public String hello(){
        return name + " " + say;
    }
}
