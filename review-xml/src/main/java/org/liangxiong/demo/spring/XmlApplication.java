package org.liangxiong.demo.spring;

import org.apache.commons.dbcp2.BasicDataSource;
import org.liangxiong.demo.spring.component.LoadTimeWeaverHelper;
import org.liangxiong.demo.spring.event.AccidentFireEvent;
import org.liangxiong.demo.spring.listener.AccidentFireListener;
import org.liangxiong.demo.spring.repository.SchoolRepository;
import org.liangxiong.demo.spring.service.ISchoolService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.instrument.classloading.LoadTimeWeaver;

import java.util.Collections;
import java.util.Locale;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:19:02
 * @Description
 */
public class XmlApplication {

    public static void main(String[] args) {
        initContainerByXML();
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
//        context.addApplicationListener(new AccidentFireListener());
        // 发布事件
        context.publishEvent(new AccidentFireEvent("fire hazard!"));
        BasicDataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
        ISchoolService schoolService = context.getBean("schoolService", ISchoolService.class);
        SchoolRepository schoolRepository = context.getBean("schoolRepository", SchoolRepository.class);
        // 需要添加spring-agent依赖;同时需要使用JVM参数:-javaagent:F:/repository/org/springframework/spring-agent/2.5.6/spring-agent-2.5.6.jar
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
//        context.getBean("accidentFireListener",AccidentFireListener.class);
    }

}
