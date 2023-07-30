package com.cpj.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther:: 陈培建
 * @Date: 2022/9/12
 * @Time: 11:33 上午
 * @Description:
 */
public class MyTest {

    private static int anInt;

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        Map<Integer,List<Integer>> map = new ConcurrentHashMap<>();
        map.put(1,list);
        List<Integer> list2=new ArrayList<>();
        list2.add(3);
        map.put(2,list);
        List<Integer> result = map.remove(1);
        System.out.println(result);

    }

    /**
     * 使用注解
     */
    public static void userAnnotation() throws Exception {
        HelloAnnotationClient helloAnnotationClient=new HelloAnnotationClient();
        Method method=helloAnnotationClient.getClass().getMethod("sayHello");
        if(method.isAnnotationPresent(HelloAnnotation.class)){
            HelloAnnotation helloAnnotation=method.getAnnotation(HelloAnnotation.class);
            //Get value of custom annotation
            System.out.println("Value : "+helloAnnotation.value());
            //Invoke sayHello method
            method.invoke(helloAnnotationClient);
        }
    }

}