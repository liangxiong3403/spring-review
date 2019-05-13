package org.liangxiong.demo.spring.config;

import org.liangxiong.demo.spring.annotation.TestAndDevelopment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liangxiong
 * @Date:2019-05-12
 * @Time:20:02
 * @Description 配置bean扫描，彻底摆脱XML文件
 */
@TestAndDevelopment
@Configuration
@ComponentScan(basePackages = "org.liangxiong.demo.spring")
public class BaseConfiguration {

}
