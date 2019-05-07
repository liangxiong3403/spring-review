package org.liangxiong.demo.spring.entity;

import org.springframework.beans.factory.annotation.Required;

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
        System.out.println("initialize...");
    }
}
