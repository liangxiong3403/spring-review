package org.liangxiong.demo.spring.entity;

/**
 * @author liangxiong
 * @Date:2019-04-29
 * @Time:21:18
 * @Description
 */
public class DerivedUser {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void initialize() {
        System.out.println("initialize...");
    }
}
