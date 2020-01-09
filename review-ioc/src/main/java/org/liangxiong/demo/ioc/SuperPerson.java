package org.liangxiong.demo.ioc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.liangxiong.demo.annotation.Super;

/**
 * @author liangxiong
 * @date 2020-01-09 21:03
 * @description
 **/
@Super
@Getter
@Setter
@ToString
public class SuperPerson extends Person {

    /**
     * 地址
     */
    private String address;
}
