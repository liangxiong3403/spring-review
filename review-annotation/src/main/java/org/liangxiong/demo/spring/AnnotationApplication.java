package org.liangxiong.demo.spring;

import org.liangxiong.demo.spring.component.DiyPropertySource;
import org.liangxiong.demo.spring.config.BeanConfiguration;
import org.liangxiong.demo.spring.config.DefaultDataSourceConfiguration;
import org.liangxiong.demo.spring.config.UserConfiguration;
import org.liangxiong.demo.spring.entity.Flower;
import org.liangxiong.demo.spring.entity.Person;
import org.liangxiong.demo.spring.service.IUserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import javax.sql.DataSource;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:19:02
 * @Description
 */
public class AnnotationApplication {

    public static void main(String[] args) {
        initContainerByConfiguration();
    }

    private static void initContainerByConfiguration() {
        // 初始化上下文
        AnnotationConfigApplicationContext context = initApplicationContext();
        // 添加自定义PropertySource
        addPropertySource(context);
        Person person = context.getBean("person", Person.class);
        Flower flower = context.getBean("flower", Flower.class);
        IUserService userService = context.getBean("userService", IUserService.class);
        DataSource dataSource = context.getBean("inMemoryDataSource", DataSource.class);
        System.out.println("person: " + person);
        System.out.println("flower's name: " + flower.getName());
        System.out.println("dataSource: " + dataSource);
        userService.login("liangxiong", "123456");
        // 获取JVM property source | 获取 environment variables(JVM优先级比环境变量高)
        System.out.println("env name: " + context.getEnvironment().getProperty("name"));
        System.out.println("env age: " + context.getEnvironment().getProperty("age"));
        System.out.println("env sex: " + context.getEnvironment().getProperty("sex"));
        System.out.println("env color: " + context.getEnvironment().getProperty("color"));
    }

    /**
     * 初始化上下文
     *
     * @return
     */
    private static AnnotationConfigApplicationContext initApplicationContext() {
        // 初始化context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        /**
         * 注册配置类;注意事项无法激活下面的配置类(使用了@Profile的注解,从而导致@PropertySource失效):
         * @TestAndDevelopment
         * @PropertySource
         */
        context.register(BeanConfiguration.class, UserConfiguration.class, DefaultDataSourceConfiguration.class, Person.class, Flower.class);
        // 获取environment
        ConfigurableEnvironment environment = context.getEnvironment();
        // 设置激活配置项
        environment.setActiveProfiles("development", "test");
        // 扫描宝
        context.scan("org.liangxiong.demo.spring.service.impl");
        // 刷新上下文
        context.refresh();
        return context;
    }

    /**
     * 添加自定义PropertySource
     *
     * @param context
     */
    private static void addPropertySource(AnnotationConfigApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources mutablePropertySources = environment.getPropertySources();
        // 定义用于@PropertySource参数占位符的属性值
        mutablePropertySources.addFirst(new DiyPropertySource("diy.property.source", "config"));
        // 自定义属性值,设置相对位置
        mutablePropertySources.addBefore("user", new DiyPropertySource("color", "red"));
    }

}
