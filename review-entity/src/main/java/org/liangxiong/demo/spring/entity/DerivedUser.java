package org.liangxiong.demo.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.Optional;

/**
 * @author liangxiong
 * @Date:2019-04-29
 * @Time:21:18
 * @Description
 */
public class DerivedUser {

    private String name;

    private int age;

    private boolean sex;

    private House house;

    private Optional<Dog> dog;

    @Qualifier("firstFood")
    @Autowired(required = false)
    private Food food;

    @Resource
    private ApplicationContext applicationContext;

    @Autowired
    public DerivedUser(House house) {
        this.house = house;
    }

    @Inject
    public void prepare(House house, @Qualifier("firstDog") Optional<Dog> dog) {
        this.house = house;
        this.dog = dog;
    }

    @Autowired
    public void setDog(Optional<Dog> dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Required
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void initialize() {
        System.out.println("DerivedUser: initialize...");
    }
}
