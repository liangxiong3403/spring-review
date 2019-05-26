package org.liangxiong.demo.spring.service.impl;

import org.liangxiong.demo.spring.dao.SchoolDAO;
import org.liangxiong.demo.spring.dao.UserDAO;
import org.liangxiong.demo.spring.service.IUserService;

import java.beans.ConstructorProperties;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:19:06
 * @Description
 */
public class UserServiceImpl implements IUserService {

    private UserDAO userDAO;

    private SchoolDAO schoolDAO;

    private int age;

    public UserServiceImpl() {
    }

    public UserServiceImpl(int age) {
        this.age = age;
    }

    @ConstructorProperties({"userDAO", "schoolDAO", "age"})
    public UserServiceImpl(UserDAO userDAO, SchoolDAO schoolDAO, int age) {
        this.userDAO = userDAO;
        this.schoolDAO = schoolDAO;
        this.age = age;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setSchoolDAO(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void eat(String food) {
        System.out.println("eat: " + food);
    }


}
