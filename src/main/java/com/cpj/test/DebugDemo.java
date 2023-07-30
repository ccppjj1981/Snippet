package com.cpj.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther:: 陈培建
 * @Date: 2022/9/12
 * @Time: 6:31 下午
 * @Description:
 */
@SpringBootApplication
public class DebugDemo implements CommandLineRunner {
    @Autowired
    private UserService userService;
    public static void main(String[] args) {
        new SpringApplication(DebugDemo.class).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user =new User();
        user.setName("fdsfd");
        userService.say(user);
        user.setName("1234");
        userService.say(user);
    }
}