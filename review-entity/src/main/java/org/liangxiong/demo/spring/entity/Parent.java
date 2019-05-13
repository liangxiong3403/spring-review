package org.liangxiong.demo.spring.entity;

import java.util.Properties;

/**
 * @author liangxiong
 * @Date:2019-04-15
 * @Time:20:27
 * @Description
 */
public abstract class Parent {

    private Properties adminEmails;

    public void setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
    }
}
