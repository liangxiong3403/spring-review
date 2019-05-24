package org.liangxiong.demo.spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author liangxiong
 * @Date:2019-05-23
 * @Time:10:16
 * @Description 自定义切面
 */
@Aspect
public class UserAspect {

    /**
     * 洗手操作
     */
    @Before("execution(* org.liangxiong.demo.spring.service.impl.*.eat(..))")
    public void washHands() {
        System.out.println("wash hands before eat meat");
    }

    /**
     * 散步操作
     */
    @AfterReturning("execution(* org.liangxiong.demo.spring.service.impl.*.eat(..))")
    public void walk() {
        System.out.println("go for a walk after eating meat");
    }
}
