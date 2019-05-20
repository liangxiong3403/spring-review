package org.liangxiong.demo.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.liangxiong.demo.spring.annotation.GenderConstraint;
import org.liangxiong.demo.spring.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author liangxiong
 * @Date:2019-05-20
 * @Time:15:52
 * @Description
 */
@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {

    /**
     * 增加用户;
     *
     * @param user 输入
     * @Valid开启对 {@link GenderConstraint}等注解的校验支持
     */
    @PostMapping
    public void addUser(@Valid @RequestBody User user) {
        log.info("user name: {}, age: {}, gender: {}", user.getName(), user.getAge(), user.getGender());
    }
}
