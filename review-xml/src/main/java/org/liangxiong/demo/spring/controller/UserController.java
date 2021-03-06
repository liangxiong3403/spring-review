package org.liangxiong.demo.spring.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.liangxiong.demo.spring.annotation.GenderConstraint;
import org.liangxiong.demo.spring.entity.User;
import org.springframework.http.MediaType;
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
    public User addUser(@Valid @RequestBody User user) {
        log.info("user name: {}, age: {}, gender: {}", user.getName(), user.getAge(), user.getGender());
        return user;
    }

    /**
     * 获取用户信息,通过矩阵变量;/users/zhangsan;age=18;sex=male
     *
     * @return
     */
    @GetMapping(path = "/matrix/{name}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE},
            headers = "diyHeader=diyHeader"
    )
    public JSONObject getUserInfo(@PathVariable String name, @MatrixVariable(name = "age", pathVar = "name") Integer age, @MatrixVariable(name = "sex", pathVar = "name") String sex) {
        JSONObject user = new JSONObject(8);
        user.put("name", name);
        user.put("age", age);
        user.put("sex", sex);
        return user;
    }

    /**
     * 获取名称
     *
     * @param name
     * @return
     */
    @GetMapping("/name")
    public String getName(@RequestParam String name) {
        return name;
    }

    /**
     * 获取cookie
     *
     * @param cookie
     * @return
     */
    @RequestMapping("/cookie")
    public String displayCookies(@CookieValue("JSESSIONID") String cookie) {
        return cookie;
    }

    /**
     * 获取header
     *
     * @param encoding
     * @param keepAlive
     * @return
     */
    @RequestMapping("/headers")
    public String displayHeaders(@RequestHeader("Accept-Encoding") String encoding, @RequestHeader("Keep-Alive") long keepAlive) {
        return encoding + " ; " + keepAlive;
    }
}
