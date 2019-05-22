package org.liangxiong.demo.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author liangxiong
 * @Date:2019-05-18
 * @Time:19:22
 * @Description 地址
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Address {

    /**
     * 名称
     */
    @NotNull
    @Size(min = 4, max = 20)
    private String name;

    /**
     * 编号
     */
    @Min(1000)
    private Integer code;

    /**
     * 电子邮件
     */
    @Email
    private String email;

    /**
     * 别名
     */
    public List<String> aliases;

}
