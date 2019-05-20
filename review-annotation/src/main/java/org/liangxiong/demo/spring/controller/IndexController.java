package org.liangxiong.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author liangxiong
 * @Date:2019-05-16
 * @Time:13:54
 * @Description 访问主页
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
