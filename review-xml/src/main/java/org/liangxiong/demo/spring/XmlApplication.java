package org.liangxiong.demo.spring;

import org.apache.commons.dbcp2.BasicDataSource;
import org.liangxiong.demo.spring.component.LoadTimeWeaverHelper;
import org.liangxiong.demo.spring.component.UserValidator;
import org.liangxiong.demo.spring.entity.Address;
import org.liangxiong.demo.spring.entity.User;
import org.liangxiong.demo.spring.event.AccidentFireEvent;
import org.liangxiong.demo.spring.listener.AccidentFireListener;
import org.liangxiong.demo.spring.repository.SchoolRepository;
import org.liangxiong.demo.spring.service.ISchoolService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.Resource;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.File;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:19:02
 * @Description
 */
public class XmlApplication {

    public static void main(String[] args) {
        initContainerByXML();
        initFileSystemApplicationContext();
        initUserInstance();
        useBeanWrapper();
        useJSR303();
    }

    private static void initContainerByXML() {
        // 初始化上下文
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        // 获取环境
        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        // 添加自定义property source 针对spring.xml中的${diy.property.source}
        propertySources.addFirst(new MapPropertySource("configPath", Collections.singletonMap("diy.property.location", "config")));
        // 加载配置文件
        reader.loadBeanDefinitions("spring.xml");
        // 刷新上下文
        context.refresh();
        // 注册事件监听器
        context.addApplicationListener(new AccidentFireListener());
        // 发布事件
        context.publishEvent(new AccidentFireEvent("fire hazard!"));
        BasicDataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
        ISchoolService schoolService = context.getBean("schoolService", ISchoolService.class);
        SchoolRepository schoolRepository = context.getBean("schoolRepository", SchoolRepository.class);
        /* 需要添加spring-agent依赖;同时需要使用JVM参数
         * windows: -javaagent:F:/repository/org/springframework/spring-agent/2.5.6/spring-agent-2.5.6.jar
         * mac: -javaagent:/Users/liangxiong/.m2//repository/org/springframework/spring-agent/2.5.6/spring-agent-2.5.6.jar
         */
        LoadTimeWeaver loadTimeWeaver = context.getBean("loadTimeWeaver", LoadTimeWeaver.class);
        // 获取message resource
        String message = context.getMessage("message", null, "default", Locale.US);
        // 获取自定义组件
        LoadTimeWeaverHelper loadTimeWeaverHelper = context.getBean("loadTimeWeaverHelper", LoadTimeWeaverHelper.class);
        // 调用
        loadTimeWeaverHelper.execute();
        System.out.println("dataSource: " + dataSource);
        System.out.println("schoolService: " + schoolService);
        System.out.println("schoolRepository: " + schoolRepository);
        System.out.println("loadTimeWeaver: " + loadTimeWeaver);
        System.out.println("message resource: " + message);
    }

    /**
     * 测试Resource
     */
    private static void initFileSystemApplicationContext() {
        String prefix = "review-xml" + File.separator + "src/main/resources/";
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(prefix + "spring.xml");
        Resource resource = context.getResource(prefix + "config/jdbc.properties");
        LoadTimeWeaver loadTimeWeaver = context.getBean("loadTimeWeaver", LoadTimeWeaver.class);
        System.out.println("loadTimeWeaver2: " + loadTimeWeaver);
        System.out.println("exists: " + resource.exists());
    }

    /**
     * 测试Validator
     */
    private static void initUserInstance() {
        // 初始化对象
        User user = new User();
        user.setName("Jack");
        user.setAge(120);
        Address address = new Address();
        address.setName("Beijing");
        address.setCode(10086);
        user.setAddress(address);
        // 获取校验器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserValidator userValidator = context.getBean("userValidator", UserValidator.class);
        // 校验数据
        if (userValidator.supports(user.getClass())) {
            Errors errors = new DirectFieldBindingResult(user, "user");
            userValidator.validate(user, errors);
            errors.getAllErrors().forEach(System.out::println);
        }
    }

    /**
     * 测试BeanWrapper
     */
    private static void useBeanWrapper() {
        BeanWrapper beanWrapper = new BeanWrapperImpl(new User());
        beanWrapper.setPropertyValue("name", "Tom");
        PropertyValue propertyValue = new PropertyValue("age", 18);
        beanWrapper.setPropertyValue(propertyValue);
        System.out.println("name from bean wrapper: " + beanWrapper.getPropertyValue("name"));
        System.out.println("age from bean wrapper: " + beanWrapper.getPropertyValue("age"));
    }

    /**
     * 测试JSR303
     */
    private static void useJSR303() {
        // 初始化上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // 获取validator工厂
        Validator validator = context.getBean("validator", Validator.class);
        Address address = new Address();
        address.setName("Shanghai");
        address.setEmail("123456@gmail.com");
        address.setCode(666);
        Set<ConstraintViolation<Address>> constraintViolations = validator.validate(address);
        constraintViolations.stream().forEach(e -> System.out.println("message: " + e.getMessage()));
    }

}
