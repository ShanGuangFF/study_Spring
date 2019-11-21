package com.xupt.ff.dao.Impl;

import com.xupt.ff.dao.IAccountDao;
import com.xupt.ff.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author cc_ff
 * @create 2019-11-20 下午5:55
 * @action
 */
@Repository
public class accountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAll() {
        try {
            return runner.query("select * from accountMoney",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(int accountId) {
        try {
            return runner.query("select * from accountMoney where id = ?",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update("insert into accountMoney(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update accountMoney set name = ? , money = ? where id = ? ",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int accountId) {
        try {
            runner.update("delete from accountMoney where id  = ? ",accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account findByName(String name){
        try {
            List<Account> accountList = runner.query("select * from accountMoney where name = ?", new BeanListHandler<Account>(Account.class), name);
            if(accountList == null || accountList.size() == 0){
                return null;
            }else if(accountList.size() > 1){
                throw new  RuntimeException("结果集不唯一，名字有误");
            }else {
                return accountList.get(0);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
