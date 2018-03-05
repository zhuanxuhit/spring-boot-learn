package com.babyfs.stage1.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // 加上这个后才能使用 spring相关功能。
@SpringBootTest
public class BabyfsConfigTest {

    @Autowired
    BabyfsConfig babyfsConfig;

    @Test
    public void getBabyfsConfig() throws Exception {
        System.out.println(babyfsConfig);
    }
}
