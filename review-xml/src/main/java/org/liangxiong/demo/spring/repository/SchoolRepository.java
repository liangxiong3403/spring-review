package org.liangxiong.demo.spring.repository;

/**
 * @author liangxiong
 * @Date:2019-05-13
 * @Time:14:28
 * @Description
 */
public class SchoolRepository {

    private final UserRepository userRepository;

    public SchoolRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
