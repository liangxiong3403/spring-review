package org.liangxiong.demo.spring.util;

import org.liangxiong.demo.spring.dao.SchoolDAO;
import org.liangxiong.demo.spring.dao.UserDAO;
import org.liangxiong.demo.spring.service.impl.SchoolServiceImpl;
import org.liangxiong.demo.spring.service.impl.UserServiceImpl;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:21:10
 * @Description
 */
public class DiyBeanFactory {

    private DiyBeanFactory() {
    }


    private static final UserServiceImpl USER_SERVICE = new UserServiceImpl();


    private static final SchoolServiceImpl SCHOOL_SERVICE = new SchoolServiceImpl();


    public UserServiceImpl createUserServiceInstance(UserDAO userDAO, SchoolDAO schoolDAO, int age) {
        return new UserServiceImpl(userDAO, schoolDAO, age);
    }

    public SchoolServiceImpl createSchoolServiceInstance() {
        return SCHOOL_SERVICE;
    }

}
