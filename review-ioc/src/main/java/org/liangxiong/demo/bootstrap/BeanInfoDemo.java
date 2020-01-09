package org.liangxiong.demo.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.liangxiong.demo.ioc.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.Arrays;

/**
 * @author liangxiong
 * @date 2020-01-05 21:03
 * @description {@link BeanInfo}示例
 **/
@Slf4j
public class BeanInfoDemo {

    private static final String NAME = "name";

    private static final String AGE = "age";

    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
            Arrays.stream(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
                Class propertyType = propertyDescriptor.getPropertyType();
                String fieldName = propertyDescriptor.getName();
                if (AGE.equals(fieldName)) {
                    propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                }
            });
        } catch (IntrospectionException e) {
            log.error("get bean error:{}", e.getMessage());
        }
    }

    /**
     * 自定义属性转换器
     */
    private static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer result = Integer.valueOf(text);
            setValue(result);
        }
    }
}
