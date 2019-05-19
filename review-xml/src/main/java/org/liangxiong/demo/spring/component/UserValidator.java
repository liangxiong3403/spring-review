package org.liangxiong.demo.spring.component;

import org.liangxiong.demo.spring.entity.Address;
import org.liangxiong.demo.spring.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author liangxiong
 * @Date:2019-05-18
 * @Time:18:52
 * @Description 自定义数据校验器
 */
public class UserValidator implements Validator {

    private static final Integer MAX_AGE = 120;

    private AddressValidator addressValidator;

    public UserValidator(AddressValidator addressValidator) {
        if (addressValidator == null) {
            throw new IllegalArgumentException("addressValidator must not be null!");
        } else if (!addressValidator.supports(Address.class)) {
            throw new IllegalArgumentException("addressValidator can not validate address");
        }
        this.addressValidator = addressValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name must not be null or empty string!");
        User user = (User) target;
        int age = user.getAge();
        if (age < 0) {
            errors.reject("age", "age must not be negative!");
        } else if (age > MAX_AGE) {
            errors.reject("age", "age must not more than 120!");
        }
        errors.pushNestedPath("address");
        ValidationUtils.invokeValidator(this.addressValidator, user.getAddress(), errors);
        errors.popNestedPath();
    }
}