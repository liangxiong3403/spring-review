package org.liangxiong.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:18:33
 * @Description
 */
@Controller
public class HelloController {

    @GetMapping("/index")
    public String index() {
        return "index.jsp";
    }
}
