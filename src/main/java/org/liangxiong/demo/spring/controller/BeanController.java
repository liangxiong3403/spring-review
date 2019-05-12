package org.liangxiong.demo.spring.controller;

import org.liangxiong.demo.spring.config.BeanConfiguration;
import org.liangxiong.demo.spring.entity.Person;
import org.liangxiong.demo.spring.repository.SchoolRepository;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:19:02
 * @Description
 */
public class BeanController {

    public static void main(String[] args) {
        initContainerByConfiguration();
    }

    private static void initContainerByXML() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("spring.xml");
        context.refresh();
        context.getBean("dataSource2");
    }

    private static void initContainerByConfiguration() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanConfiguration.class, Person.class);
        context.refresh();
        Person person = context.getBean("person", Person.class);
        SchoolRepository repository = context.getBean("schoolRepository", SchoolRepository.class);
        System.out.println("person: " + person);
        System.out.println("repository: " + repository);
    }

}
