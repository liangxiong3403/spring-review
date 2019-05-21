package org.liangxiong.demo.spring.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liangxiong
 * @Date:2019-05-13
 * @Time:9:38
 * @Description
 */
@Component
public class Flower {

    private String name;

    private String color;

    @Value("#{T(java.lang.Math).random() * 50.0}")
    private int age;

    @PostConstruct
    public void init() {
        this.name = "rose";
        this.color = "red";
    }

    public String getName() {
        return name;
    }

    @Value("#{ systemProperties['user.name'] }")
    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
