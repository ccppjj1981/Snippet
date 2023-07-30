package com.cpj.test;

/**
 * @Auther:: 陈培建
 * @Date: 2022/12/4
 * @Time: 10:57 下午
 * @Description:
 */
public class HelloAnnotationClient {
    @HelloAnnotation(value="Simple custom Annotation example")
    public void sayHello(){
        System.out.println("Inside sayHello method..");
    }
}