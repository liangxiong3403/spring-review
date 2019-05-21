package org.liangxiong.demo.spring.config;

import org.liangxiong.demo.spring.annotation.TestAndDevelopment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

/**
 * @author liangxiong
 * @Date:2019-05-12
 * @Time:20:02
 * @Description 配置bean扫描，彻底摆脱XML文件;excludeFilters排除扫描WebConfiguration,因为已经import了
 */
@TestAndDevelopment
@Import(WebConfiguration.class)
@Configuration
@ComponentScan(basePackages = "org.liangxiong.demo.spring", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebConfiguration.class))
public class BaseConfiguration {

}
