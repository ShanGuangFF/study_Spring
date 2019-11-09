package com.xupt.ff.ui;

import com.xupt.ff.dao.impl.accountDaoImpl;
import com.xupt.ff.service.impl.accountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cc_ff
 * @create 2019-11-10 上午1:03
 * @action
 */
public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //2.根据id获取bean对象
        accountDaoImpl accountDao = applicationContext.getBean("accountDao", accountDaoImpl.class);
        accountServiceImpl accountService = applicationContext.getBean("accountService", accountServiceImpl.class);

        System.out.println(accountDao);
        System.out.println(accountService);
    }
}
