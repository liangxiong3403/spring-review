package org.liangxiong.demo.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:18:33
 * @Description
 */
@RestController
public class HelloController {

    @GetMapping("/index")
    public String index() {
        return "index.jsp";
    }
}
