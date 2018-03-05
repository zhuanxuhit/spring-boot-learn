package com.babyfs.stage1.enable;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(MyLogImportBeanDefinitionRegistrar.class)
public @interface EnableMyLogAutoConfiguration {
    // 注意：此处 EnableMyLogAutoConfiguration 的注解信息会被传入到 MyLogImportBeanDefinitionRegistrar 中
    String basePackage() default "";

}
