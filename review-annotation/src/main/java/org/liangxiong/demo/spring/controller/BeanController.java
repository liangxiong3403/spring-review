package org.liangxiong.demo.spring.controller;

import org.liangxiong.demo.spring.config.FoodConfiguration;
import org.liangxiong.demo.spring.entity.Flower;
import org.liangxiong.demo.spring.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:19:02
 * @Description
 */
public class BeanController {

    public static void main(String[] args) {
        initContainerByConfiguration();
    }

    private static void initContainerByConfiguration() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(FoodConfiguration.class, Person.class);
        context.refresh();
        Person person = context.getBean("person", Person.class);
        Flower flower = context.getBean("flower", Flower.class);
        System.out.println("person: " + person);
        System.out.println("flower's name: " + flower.getName());
    }

}
