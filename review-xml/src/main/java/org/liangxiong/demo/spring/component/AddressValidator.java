package org.liangxiong.demo.spring.component;

import org.liangxiong.demo.spring.entity.Address;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author liangxiong
 * @Date:2019-05-18
 * @Time:19:24
 * @Description 地址校验
 */
public class AddressValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "address's name must not be null or empty string!");
        ValidationUtils.rejectIfEmpty(errors, "code", "address's code must not be null or empty string!");
    }
}
