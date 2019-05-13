package org.liangxiong.demo.spring.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.liangxiong.demo.spring.service.IUserService;
import org.liangxiong.demo.spring.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liangxiong
 * @Date:2019-05-13
 * @Time:10:08
 * @Description
 */
@Configuration
public class UserConfiguration {

    private BasicDataSource dataSource;

    @Autowired
    private RepositoryConfiguration repositoryConfiguration;

    public UserConfiguration(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public IUserService userService() {
        return new UserServiceImpl(repositoryConfiguration.dataSource());
    }
}
