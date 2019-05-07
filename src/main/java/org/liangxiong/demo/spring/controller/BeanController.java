package org.liangxiong.demo.spring.controller;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:19:02
 * @Description
 */
public class BeanController {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("spring.xml");
        context.refresh();
        context.getBean("dataSource2");
    }

}
