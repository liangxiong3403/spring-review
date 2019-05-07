package org.liangxiong.demo.spring.dao;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:19:59
 * @Description
 */
public class UserDAO {

    private Integer userId;

    private SchoolDAO schoolDAO;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setSchoolDAO(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }
}
