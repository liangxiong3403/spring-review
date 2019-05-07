package org.liangxiong.demo.spring.entity;

/**
 * @author liangxiong
 * @Date:2019-04-29
 * @Time:21:13
 * @Description
 */
public abstract class AbstractUser {

    private String name;

    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
