package org.liangxiong.demo.dependency.lookup;

import org.liangxiong.demo.ioc.Repository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liangxiong
 * @date 2020-01-09 21:20
 * @description
 **/
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        Repository repository = context.getBean("repository", Repository.class);
        System.out.println(repository.getPersonObjectFactory().getObject());
        System.out.println(repository.getApplicationContextObjectFactory().getObject() == context);
    }
}
