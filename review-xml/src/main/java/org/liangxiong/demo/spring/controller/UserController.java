package org.liangxiong.demo.spring.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.liangxiong.demo.spring.annotation.GenderConstraint;
import org.liangxiong.demo.spring.entity.User;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 获取用户信息,通过矩阵变量;/users/zhangsan;age=18;sex=male
     *
     * @return
     */
    @GetMapping("/matrix/{name}")
    public JSONObject getUserInfo(@PathVariable String name, @MatrixVariable(name = "age", pathVar = "name") Integer age, @MatrixVariable(name = "sex", pathVar = "name") String sex) {
        JSONObject user = new JSONObject(8);
        user.put("name", name);
        user.put("age", age);
        user.put("sex", sex);
        return user;
    }
}
