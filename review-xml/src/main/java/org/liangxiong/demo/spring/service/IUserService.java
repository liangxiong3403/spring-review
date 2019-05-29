package org.liangxiong.demo.spring.service;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:19:04
 * @Description 用户业务处理
 */
public interface IUserService {

    /**
     * eat food
     *
     * @param food 食品名称
     */
    void eat(String food);

    /**
     * 获取名称
     *
     * @param id 主键
     * @return
     */
    String getName(Integer id);

    /**
     * 设置名称
     *
     * @param name 名称
     */
    void setName(String name);
}
