package org.liangxiong.demo.spring.component;

import org.liangxiong.demo.spring.annotation.GenderConstraint;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author liangxiong
 * @Date:2019-05-20
 * @Time:10:59
 * @Description 自定义ConstraintValidator处理自定义注解
 */
public class GenderConstraintValidator implements ConstraintValidator<GenderConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.hasText(value)) {
            String male = "male";
            String female = "female";
            if (male.equals(value)) {
                return true;
            } else if (female.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
