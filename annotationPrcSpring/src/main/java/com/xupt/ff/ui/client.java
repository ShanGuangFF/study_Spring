package com.xupt.ff.ui;

import com.xupt.ff.service.impl.accountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cc_ff
 * @create 2019-11-19 下午9:49
 * @action
 */
public class client {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        accountServiceImpl accountService = ac.getBean("accountService",accountServiceImpl.class);
        accountService.saveAccount();
    }
}
