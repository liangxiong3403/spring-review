package org.liangxiong.demo.spring.config;

import org.liangxiong.demo.spring.entity.Dog;
import org.liangxiong.demo.spring.entity.Food;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @author liangxiong
 * @Date:2019-05-12
 * @Time:10:26
 * @Description 手动配置bean;Any ${…} placeholders present in a @PropertySource resource location will be resolved against the
 * set of property sources already registered against the environment
 */
@PropertySource(name = "user", value = "classpath:${diy.property.source:config}/user.properties")
@Configuration
public class BeanConfiguration {

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

    @Bean("inMemoryDataSource")
    @Profile("development")
    public DataSource standaloneDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL).build();
    }
}
