package org.liangxiong.demo.spring.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liangxiong
 * @Date:2019-05-18
 * @Time:18:49
 * @Description 用户实体
 */
@Getter
@Setter
public class User {

    /**
     * 用户名称
     */
    private String name;

    /**
     * 密码
     */
    private int age;

    /**
     * 地址
     */
    private Address address;
}
