package org.liangxiong.demo.spring.aop;

/**
 * @author liangxiong
 * @Date:2019-05-23
 * @Time:10:16
 * @Description 自定义切面
 */
public class UserAspect {

    /**
     * 洗手操作
     */
    public void washHands() {
        System.out.println("wash hands before eat meat");
    }

    /**
     * 散步操作
     */
    public void walk() {
        System.out.println("go for a walk after eating meat");
    }
}
