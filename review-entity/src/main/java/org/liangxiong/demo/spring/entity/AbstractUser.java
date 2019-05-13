package org.liangxiong.demo.spring.entity;

/**
 * @author liangxiong
 * @Date:2019-04-29
 * @Time:21:13
 * @Description
 */
public abstract class AbstractUser {

    private String name;

    private int age;

    private boolean sex;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
