package com.babyfs.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(LearnApplication.class,args);
        context.close();
    }
}
