package com.babyfs.stage1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class Ex2Application {
    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(Ex2Application.class);
        ConfigurableApplicationContext context =SpringApplication.run(Ex2Application.class,args);
//        System.out.println(context.getBeanFactory().getClass());

        log.info(context.getBean("getMockService").toString());

        context.close();
    }
}
