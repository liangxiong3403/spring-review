package org.liangxiong.demo.spring.config;

import org.liangxiong.demo.spring.repository.SchoolRepository;
import org.liangxiong.demo.spring.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liangxiong
 * @Date:2019-05-13
 * @Time:14:28
 * @Description
 */
@Configuration
public class WebConfiguration {

    @Bean
    public SchoolRepository schoolRepository() {
        return new SchoolRepository(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

}
