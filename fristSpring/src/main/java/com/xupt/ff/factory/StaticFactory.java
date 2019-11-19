package com.xupt.ff.factory;

import com.xupt.ff.service.IAccountService;
import com.xupt.ff.service.impl.accountServiceImpl;

import java.util.Date;

/**
 * @author cc_ff
 * @create 2019-11-11 下午10:22
 * @action 模拟一个工厂类（该类可能是存在与jar包中的，我们无法通过修改源码的方式来提供默认的构造函数）
 */
public class StaticFactory {

    public static IAccountService getAccountService(){
        return new accountServiceImpl("简十遇",18,new Date());
    }
}
