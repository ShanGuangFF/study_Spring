package com.xupt.ff.ui;

import com.xupt.ff.dao.impl.accountDaoImpl;
import com.xupt.ff.service.impl.accountServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cc_ff
 * @create 2019-11-10 上午1:03
 * @action 模拟一个表现层，用于调用业务
 */
public class Client {


    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //2.根据id获取bean对象
        accountDaoImpl accountDao = applicationContext.getBean("accountDao", accountDaoImpl.class);

        //默认构造函数创建
        accountServiceImpl accountService1 = applicationContext.getBean("accountService1", accountServiceImpl.class);
        //普通工厂创建
        accountServiceImpl accountService2 = applicationContext.getBean("accountService2",accountServiceImpl.class);
        //工厂中的静态方法创建
        accountServiceImpl accountService3 = applicationContext.getBean("accountService3",accountServiceImpl.class);

        accountService1.saveAccount();
        accountService2.saveAccount();
        accountService3.saveAccount();
    }
}
