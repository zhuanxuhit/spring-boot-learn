package com.babyfs.stage1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world
 *
 */
@SpringBootApplication
@RestController
public class Ex1App
{

    @GetMapping("/")
    public String index(){
        return "Hello Spring Boot!";
    }

    public static void main( String[] args )
    {
        SpringApplication.run(Ex1App.class, args);
    }
}
