package org.liangxiong.demo.ioc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author liangxiong
 * @date 2020-01-05 21:00
 * @description 人
 **/
@Getter
@Setter
@ToString
public class Person {

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
}
