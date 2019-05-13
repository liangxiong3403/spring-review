package org.liangxiong.demo.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.liangxiong.demo.spring.repository.GoodRepository;
import org.liangxiong.demo.spring.service.IOrderService;

/**
 * @author liangxiong
 * @Date:2019-05-13
 * @Time:10:07
 * @Description
 */
@Slf4j
public class OrderServiceImpl implements IOrderService {

    private GoodRepository goodRepository;

    public OrderServiceImpl(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    @Override
    public void addOrder(String username, Integer amount, String good) {
        log.info("add order...");
    }
}
