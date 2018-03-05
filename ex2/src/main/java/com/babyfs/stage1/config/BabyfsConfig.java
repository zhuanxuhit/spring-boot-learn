package com.babyfs.stage1.config;


import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="com.babyfs")
@SpringBootConfiguration
@Data
public class BabyfsConfig {
    private String name;
    private String say;


    @Bean
    public IMockService getMockService() {
        return new MockServiceImpl();
    }


}
