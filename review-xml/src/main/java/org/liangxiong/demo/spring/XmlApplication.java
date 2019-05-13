package org.liangxiong.demo.spring;

import org.apache.commons.dbcp2.BasicDataSource;
import org.liangxiong.demo.spring.repository.SchoolRepository;
import org.liangxiong.demo.spring.service.ISchoolService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

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
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("spring.xml");
        context.refresh();
        BasicDataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
        ISchoolService schoolService = context.getBean("schoolService", ISchoolService.class);
        SchoolRepository schoolRepository = context.getBean("schoolRepository", SchoolRepository.class);
        System.out.println("dataSource: " + dataSource);
        System.out.println("schoolService: " + schoolService);
        System.out.println("schoolRepository: " + schoolRepository);
    }

}
