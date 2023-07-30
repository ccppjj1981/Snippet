package com.cpj.test;

import org.springframework.stereotype.Component;

/**
 * @Auther:: 陈培建
 * @Date: 2022/9/12
 * @Time: 6:39 下午
 * @Description:
 */
@Component
public class UserService {
    public void say(User user){
        System.out.println("hello" + user.getName());
    }
}