package com.cpj.test;

/**
 * @Auther:: 陈培建
 * @Date: 2022/9/12
 * @Time: 6:37 下午
 * @Description:
 */
public class User {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Long id;
    private String name;
}