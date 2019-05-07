package org.liangxiong.demo.spring.entity;

import org.liangxiong.demo.spring.dao.UserDAO;

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

    private UserDAO userDAO;

    private Dog dog;

    public Children() {
    }

    public Children(String name, UserDAO userDAO) {
        this.name = name;
        this.userDAO = userDAO;
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
