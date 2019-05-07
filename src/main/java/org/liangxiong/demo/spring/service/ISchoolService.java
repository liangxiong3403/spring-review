package org.liangxiong.demo.spring.service;

/**
 * @author liangxiong
 * @Date:2019-04-14
 * @Time:21:16
 * @Description 学校业务处理
 */
public interface ISchoolService {

    /**
     * 教授科目
     *
     * @param subject 科目名称
     */
    void teach(String subject);
}
