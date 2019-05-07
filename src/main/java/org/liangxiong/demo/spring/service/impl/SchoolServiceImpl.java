package org.liangxiong.demo.spring.service.impl;

import org.liangxiong.demo.spring.entity.Person;
import org.liangxiong.demo.spring.service.ISchoolService;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:21:17
 * @Description
 */
public class SchoolServiceImpl implements ISchoolService {

    private Person target;

    private Properties adminEmails;

    private List<Object> someList;

    private Map<String, Object> someMap;

    private Set<Object> someSet;

    public void setSomeMap(Map<String, Object> someMap) {
        this.someMap = someMap;
    }

    public void setSomeSet(Set<Object> someSet) {
        this.someSet = someSet;
    }

    public void setSomeList(List<Object> someList) {
        this.someList = someList;
    }

    public void setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
    }

    public void setTarget(Person target) {
        this.target = target;
    }

    @Override
    public void teach(String subject) {
        System.out.println("teach: " + subject);
    }

}
