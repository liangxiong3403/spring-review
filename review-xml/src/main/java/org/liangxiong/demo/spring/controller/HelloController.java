package org.liangxiong.demo.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangxiong
 * @Date:2019-05-16
 * @Time:13:54
 * @Description
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello,World";
    }
}
