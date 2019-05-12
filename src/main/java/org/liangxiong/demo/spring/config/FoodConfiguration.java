package org.liangxiong.demo.spring.config;

import org.liangxiong.demo.spring.entity.Dog;
import org.liangxiong.demo.spring.entity.Food;
import org.springframework.context.annotation.*;

/**
 * @author liangxiong
 * @Date:2019-05-12
 * @Time:10:26
 * @Description
 */
@ComponentScan(basePackages = "org.liangxiong.demo.spring.repository")
@Configuration
public class FoodConfiguration {

    @Description("instantiate food programmatic,test multiple bean definition")
    @Primary
    @Bean("firstFood")
    public Food firstFood() {
        Food food = new Food();
        food.setName("meat");
        return food;
    }

    @Bean
    public Dog firstDog() {
        return new Dog();
    }
}
