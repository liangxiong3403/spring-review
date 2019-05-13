package org.liangxiong.demo.spring.entity;

/**
 * @author liangxiong
 * @Date:2019-04-15
 * @Time:21:54
 * @Description 宠物狗
 */
public class Dog {

    private Food food;

    public Dog() {
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Food getFood() {
        return food;
    }
}
