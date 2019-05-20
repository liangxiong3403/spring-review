package org.liangxiong.demo.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author liangxiong
 * @Date:2019-05-12
 * @Time:20:02
 * @Description 配置bean扫描，彻底摆脱XML文件
 */
@Import({WebConfiguration.class, BeanConfiguration.class, UserConfiguration.class, OrderConfiguration.class})
@Configuration
@ComponentScan(basePackages = "org.liangxiong.demo.spring")
public class BaseConfiguration {

}
