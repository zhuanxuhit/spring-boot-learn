package com.babyfs.springboot.core.io.support;


import lombok.extern.slf4j.Slf4j;
import org.mockito.internal.util.collections.ListUtil;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SpringFactoriesLoaderRunner implements ApplicationRunner, BeanClassLoaderAware{

    private ClassLoader beanClassLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("just test for SpringFactoriesLoader");
        log.info(beanClassLoader.getClass().getName());
        List<String>  loaders =  SpringFactoriesLoader.loadFactoryNames(Loader.class,beanClassLoader);
        log.info(loaders.toString());
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
    }
}
