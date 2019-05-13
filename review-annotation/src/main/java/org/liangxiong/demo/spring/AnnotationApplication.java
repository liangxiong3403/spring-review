package org.liangxiong.demo.spring;

import org.liangxiong.demo.spring.config.BeanConfiguration;
import org.liangxiong.demo.spring.entity.Flower;
import org.liangxiong.demo.spring.entity.Person;
import org.liangxiong.demo.spring.service.IUserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:19:02
 * @Description
 */
public class AnnotationApplication {

    public static void main(String[] args) {
        initContainerByConfiguration();
    }

    private static void initContainerByConfiguration() {
        // 初始化context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册配置类
        context.register(BeanConfiguration.class, Person.class);
        // 获取environment
        ConfigurableEnvironment environment = context.getEnvironment();
        // 设置激活配置项
        environment.setActiveProfiles("test");
        // 刷新上下文
        context.refresh();
        Person person = context.getBean("person", Person.class);
        Flower flower = context.getBean("flower", Flower.class);
        IUserService userService = context.getBean("userService", IUserService.class);
        System.out.println("person: " + person);
        System.out.println("flower's name: " + flower.getName());
        userService.login("liangxiong", "123456");
    }

}
