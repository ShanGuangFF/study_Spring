package com.xupt.ff.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author cc_ff
 * @create 2019-11-21 上午9:19
 * @action 利用和事务相关的工具类,控制事务
 */
@Component
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    /**
     * @action 开启事务
     */
    public void startTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @action 提交事务
     */
    public void commitTransaction(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @action 回滚事务
     */
    public void rollbackTransaction(){
        try {
            connectionUtils.getThreadConnection().rollback();
            System.out.println("rollback执行了");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @action 释放连接
     */
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();//还回连接池
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
