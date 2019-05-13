package org.liangxiong.demo.spring.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liangxiong
 * @Date:2019-05-13
 * @Time:11:38
 * @Description
 */
@Configuration
public class DefaultRepositoryConfiguration implements RepositoryConfiguration {

    @Override
    @Bean
    public BasicDataSource dataSource() {
        return new BasicDataSource();
    }
}
