package com.cpj.snippet.filter;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 定义开关@EnableLog注解
 * <p>
 * 后面只需在springboot启动类加上@EnableLog注解，
 * 即可开启LogFilter记录请求和响应日志的功能。
 *
 * @author chenpeijian
 * @date 2023/2/15 21:15
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LogFilterWebConfig.class)
public @interface EnableLog {

}
