package org.liangxiong.demo.spring.entity;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liangxiong
 * @Date:2019-05-13
 * @Time:9:38
 * @Description
 */
@Getter
@Component
public class Flower {

    private String name;

    private String color;

    @PostConstruct
    public void init() {
        this.name = "rose";
        this.color = "red";
    }
}
