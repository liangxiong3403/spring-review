package org.liangxiong.demo.spring.entity;

import java.util.Map;
import java.util.Properties;

/**
 * @author liangxiong
 * @Date:2019-04-15
 * @Time:20:29
 * @Description
 */
public class Children extends Parent {

    private Properties adminEmails;

    private Map<String, Float> accounts;

    private String name;

    private Dog dog;

    public Children() {
    }

    public Children(String name) {
        this.name = name;
    }

    @Override
    public void setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
    }

    public void setAccounts(Map<String, Float> accounts) {
        this.accounts = accounts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
