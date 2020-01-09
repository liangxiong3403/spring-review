package org.liangxiong.demo.dependency.lookup;

import org.liangxiong.demo.annotation.Super;
import org.liangxiong.demo.ioc.Person;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author liangxiong
 * @date 2020-01-09 20:34
 * @description 依赖查找测试
 **/
public class DependencyLookUpDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        lookUpInRealTime(context);
        lookUpInLazy(context);
        lookUpByType(context);
        lookUpCollectionBeanByType(context);
        lookUpBeanByAnnotation(context);
    }

    private static void lookUpBeanByAnnotation(ApplicationContext context) {
        context.getBeansWithAnnotation(Super.class).forEach((key, value) -> System.out.println("lookUpBeanByAnnotation key: " + key + ",value: " + value));
    }

    private static void lookUpCollectionBeanByType(ApplicationContext context) {
        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        beansOfType.forEach((key, value) -> System.out.println("lookUpCollectionBeanByType key: " + key + ",value: " + value));
    }

    private static void lookUpByType(ApplicationContext context) {
        Person person = context.getBean(Person.class);
        System.out.println("lookUpByType: " + person);
    }

    /**
     * 实时查找
     *
     * @param context
     */
    private static void lookUpInRealTime(ApplicationContext context) {
        Person person = (Person) context.getBean("person");
        System.out.println("lookUpInRealTime: " + person);
    }

    /**
     * 延时查找
     *
     * @param context
     */
    private static void lookUpInLazy(ApplicationContext context) {
        ObjectFactory<Person> objectFactory = (ObjectFactory<Person>) context.getBean("creatingFactoryBean");
        System.out.println("lookUpInLazy: " + objectFactory.getObject());
    }
}
