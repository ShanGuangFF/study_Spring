package com.xupt.ff.ui;

import com.xupt.ff.dao.impl.accountDaoImpl;
import com.xupt.ff.service.impl.accountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cc_ff
 * @create 2019-11-10 上午1:03
 * @action 模拟一个表现层，用于调用业务
 */
public class Client {

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     * ApplicationContext的三个常用实现类
     *      ClassPathXmlApplicationContext :它可以加载类路径下的配置文件，要求配置文件必须在类路径下
     *      FileSystemXmlApplicationContext :它可以加载磁盘任意路径下的配置文件，（必须有访问权限）
     *      AnnotationConfigApplicationContext :它可以用于读取注解创建容器的。
     *
     * 核心容器的两个接口引发出的问题：
     *      ApplicationContext： 单例对象适用
     *          它在构建核心容器时，创建对象是采取立即加载的方式
     *
     *      BeanFactory：    多例对象适用
     *          它在构建核心容器时，创建对象是采取延迟加载的方式
     *
     * @param args
     */
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
