package com.xupt.ff.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author cc_ff
 * @create 2019-11-21 上午9:10
 * @action 连接的工具类，它用于从数据源绑定一个数据，并实现和线程的绑定
 */

@Component
public class ConnectionUtils {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    /**
     * @action 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        try {
            //1. 先从ThreadLocal上获取
            Connection connection = threadLocal.get();
            //2. 判断当前线程上是否有连接
            if (connection == null){
                //3. 从数据源里取出一个连接ThreadLocal中
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            //4. 返回线程上的连接
            return connection;
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }

    /**
     * @action 把连接和线程解绑
     */
    public void removeConnection(){
        threadLocal.remove();
    }
}
