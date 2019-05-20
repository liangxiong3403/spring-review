package org.liangxiong.demo.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.liangxiong.demo.spring.annotation.GenderConstraint;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @author liangxiong
 * @Date:2019-05-18
 * @Time:18:49
 * @Description 用户实体
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    /**
     * 用户名称
     */
    @Size(min = 1, max = 10)
    private String name;

    /**
     * 密码
     */
    @Min(1)
    @Max(120)
    private int age;

    /**
     * 地址
     */
    private Address address;

    /**
     * 性別
     */
    @GenderConstraint
    private String gender;
}
