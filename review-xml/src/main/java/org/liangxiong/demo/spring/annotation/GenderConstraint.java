package org.liangxiong.demo.spring.annotation;

import org.liangxiong.demo.spring.component.GenderConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.Valid;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liangxiong
 * @Date:2019-05-20
 * @Time:11:01
 * @Description 自定义注解, 处理性别字段;通过{@link Valid}开启Web层的支持
 */
@Constraint(validatedBy = GenderConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface GenderConstraint {

    String message() default "{the value of gender is invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
