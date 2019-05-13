package org.liangxiong.demo.spring.entity;

/**
 * @author liangxiong
 * @Date:2019-04-16
 * @Time:21:03
 * @Description
 */
public class House {

    private Dog dog;

    private Children children;

    public House() {
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setChildren(Children children) {
        this.children = children;
    }
}
