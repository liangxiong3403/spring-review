package org.liangxiong.demo.spring.service;

/**
 * @author liangxiong
 * @Date:2019-05-13
 * @Time:10:02
 * @Description
 */
public interface IUserService {

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    String login(String username, String password);
}
