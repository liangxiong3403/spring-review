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
import org.liangxiong.demo.spring.service.IUserService;
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
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.File;
import java.util.*;

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
        useSpringExpressionLanguage();
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
        context.close();
    }

    /**
     * 测试Resource
     */
    private static void initFileSystemApplicationContext() {
        String prefix = "review-xml" + File.separator + "src/main/resources/";
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(prefix + "spring.xml");
        Resource resource = context.getResource(prefix + "config/jdbc.properties");
        LoadTimeWeaver loadTimeWeaver = context.getBean("loadTimeWeaver", LoadTimeWeaver.class);
        IUserService userService = context.getBean("userService", IUserService.class);
        System.out.println("loadTimeWeaver2: " + loadTimeWeaver);
        userService.eat("meat");
        userService.setName("王巧姐");
        System.out.println("exists: " + resource.exists());
        System.out.println("userService: " + userService);
        System.out.println("name: " + userService.getName(17));
        context.close();
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
        context.close();
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
        context.close();
    }

    /**
     * 使用Spring Expression Language
     */
    private static void useSpringExpressionLanguage() {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello World'");
        String value = expression.getValue(String.class);
        System.out.println("value: " + value);
        Expression expressionConcat = parser.parseExpression("'Hello World'.concat('!')");
        String concatValue = expressionConcat.getValue(String.class);
        System.out.println("concatValue: " + concatValue);
        Expression expressionBytes = parser.parseExpression("'Hello World'.bytes");
        byte[] bytesValue = expressionBytes.getValue(byte[].class);
        System.out.println("byte array length: " + bytesValue.length);
        Expression expressionLength = parser.parseExpression("'Hello World'.bytes.length");
        int length = expressionLength.getValue(int.class);
        System.out.println("byte array length method2: " + length);
        Expression expressionUpperCase = parser.parseExpression("new String('hello world').toUpperCase()");
        String upperCaseValue = expressionUpperCase.getValue(String.class);
        System.out.println("upperCaseValue: " + upperCaseValue);
        // 解析对象属性
        User tom = new User("Tom Cruise", 18, null, "male");
        Expression expressionName = parser.parseExpression("name");
        String name = expressionName.getValue(tom, String.class);
        System.out.println("name: " + name);
        Expression expressionCondition = parser.parseExpression("'Tom Cruise'.equals(name)");
        boolean valueCondition = expressionCondition.getValue(tom, Boolean.class);
        System.out.println("valueCondition: " + valueCondition);
        // 使用EvaluationContext
        Address address = new Address();
        address.setAliases(Arrays.asList("red"));
        StandardEvaluationContext context = new StandardEvaluationContext();
        parser.parseExpression("aliases[0]").setValue(context, address, "blue");
        String alias = address.getAliases().get(0);
        System.out.println("alias: " + alias);
        // Parser configuration
        SpelParserConfiguration configuration = new SpelParserConfiguration(true, true);
        ExpressionParser parserFromConfiguration = new SpelExpressionParser(configuration);
        Expression expressionFromConfiguration = parserFromConfiguration.parseExpression("aliases[2]");
        String addressFromConfiguration = expressionFromConfiguration.getValue(new Address(), String.class);
        System.out.println("address's value from alias[2]: " + addressFromConfiguration);
        // Inline lists
        List numbersOfList = parser.parseExpression("{1,2,3,4}").getValue(context, List.class);
        List listOfLists = parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(context, List.class);
        numbersOfList.stream().forEach(System.out::println);
        listOfLists.stream().forEach(System.out::println);
        // Inline Maps
        Map inventorInfo = parser.parseExpression("{'name':'Nikola','dob':'10-July-1856'}").getValue(context, Map.class);
        Map mapOfMaps = parser.parseExpression("{'name':{first:'Nikola','last':'Tesla'},dob:{day:10,month:'July',year:1856}}").getValue(context, Map.class);
        System.out.println("inventorInfo: " + inventorInfo);
        System.out.println("mapOfMaps: " + mapOfMaps);

    }
}
