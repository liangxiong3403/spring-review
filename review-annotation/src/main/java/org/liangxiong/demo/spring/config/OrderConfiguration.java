package org.liangxiong.demo.spring.config;

import org.liangxiong.demo.spring.repository.GoodRepository;
import org.liangxiong.demo.spring.service.IOrderService;
import org.liangxiong.demo.spring.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liangxiong
 * @Date:2019-05-13
 * @Time:10:08
 * @Description 订单配置类
 */
@Configuration
public class OrderConfiguration {

    @Autowired
    private GoodRepository goodRepository;

    @Bean
    public IOrderService orderService() {
        return new OrderServiceImpl(goodRepository);
    }
}
