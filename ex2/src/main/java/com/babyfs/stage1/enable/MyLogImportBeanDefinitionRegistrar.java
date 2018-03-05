package com.babyfs.stage1.enable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class MyLogImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    private static Logger log = LoggerFactory.getLogger(MyLogImportBeanDefinitionRegistrar.class);

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if (log.isDebugEnabled()){
            log.debug("registerBeanDefinitions");
        }
        // 获取注解信息
        Map<String, Object>  attributes =  importingClassMetadata.getAnnotationAttributes(EnableMyLogAutoConfiguration.class.getName());
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(attributes);
        String basePackage =  annoAttrs.getString("basePackage");
        // 有了包路径后，我们下一步需要去加载我们需要关注的 Bean

    }
}
