package org.liangxiong.demo.spring.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liangxiong
 * @Date:2019-05-18
 * @Time:19:22
 * @Description 地址
 */
@Setter
@Getter
public class Address {

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private Integer code;
}
