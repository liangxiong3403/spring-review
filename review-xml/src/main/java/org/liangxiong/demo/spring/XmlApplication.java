package org.liangxiong.demo.spring;

import org.apache.commons.dbcp2.BasicDataSource;
import org.liangxiong.demo.spring.repository.SchoolRepository;
import org.liangxiong.demo.spring.service.ISchoolService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.Collections;

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
        BasicDataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
        ISchoolService schoolService = context.getBean("schoolService", ISchoolService.class);
        SchoolRepository schoolRepository = context.getBean("schoolRepository", SchoolRepository.class);
        System.out.println("dataSource: " + dataSource);
        System.out.println("schoolService: " + schoolService);
        System.out.println("schoolRepository: " + schoolRepository);
    }

}
