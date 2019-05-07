package org.liangxiong.demo.spring.entity;

/**
 * @author liangxiong
 * @Date:2019-04-15
 * @Time:21:55
 * @Description 食物
 */
public class Food {

    /**
     * 食物名称
     */
    private String name;

    public Food() {
    }

    /**
     * 初始化方法
     */
    public void init() {
        System.out.println("init method");
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 销毁方法
     */
    public void destroy() {
        System.out.println("init method");
    }

}
