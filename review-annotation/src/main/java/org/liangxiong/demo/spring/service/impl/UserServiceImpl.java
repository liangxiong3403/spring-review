package org.liangxiong.demo.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.liangxiong.demo.spring.service.IUserService;

/**
 * @author liangxiong
 * @Date:2019-05-13
 * @Time:10:03
 * @Description
 */
@Slf4j
public class UserServiceImpl implements IUserService {

    private final BasicDataSource dataSource;

    public UserServiceImpl(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String login(String username, String password) {
        log.info("login process: username: {}, password: {}", username, password);
        return "success";
    }
}
