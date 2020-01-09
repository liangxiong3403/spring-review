package org.liangxiong.demo.ioc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @author liangxiong
 * @date 2020-01-09 21:18
 * @description
 **/
@ToString
@Getter
@Setter
public class Repository {

    private List<Person> personList;

    private ObjectFactory<Person> personObjectFactory;

    private ObjectFactory<ApplicationContext> applicationContextObjectFactory;

}
