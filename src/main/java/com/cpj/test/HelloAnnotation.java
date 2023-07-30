package com.cpj.test;

import java.lang.annotation.*;

/**
 * @Auther: 陈培建
 * @Date: 2022/12/4 - 12 - 04 - 10:54 下午
 * @Description: com.cpj.test
 * @version: 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface HelloAnnotation {
    String value();
}
