package org.liangxiong.demo.spring.service;

/**
 * @author liangxiong
 * @Date:2019-05-13
 * @Time:10:06
 * @Description
 */
public interface IOrderService {

    /**
     * 增加订单
     *
     * @param username 用户名
     * @param amount   账户id
     * @param good     商品名称
     */
    void addOrder(String username, Integer amount, String good);
}
