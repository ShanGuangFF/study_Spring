package com.xupt.ff.service.impl;

import com.xupt.ff.service.IAccountService;

import java.util.Date;

/**
 * @author cc_ff
 * @create 2019-11-10 上午1:02
 * @action
 */
public class accountServiceImpl implements IAccountService {

    //经常变化的数据，不适合注入
    private String name;
    private int age;
    private Date date;

    public accountServiceImpl(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public accountServiceImpl() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void init() {
        System.out.println("初始化了");
    }

    public void destroy() {
        System.out.println("被销毁了");
    }

    public void saveAccount() {
        System.out.println("accountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}');
    }


}
