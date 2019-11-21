package com.xupt.ff.service.Impl;

import com.xupt.ff.dao.IAccountDao;
import com.xupt.ff.domain.Account;
import com.xupt.ff.service.IAccountService;
import com.xupt.ff.utils.ConnectionUtils;
import com.xupt.ff.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cc_ff
 * @create 2019-11-20 下午5:56
 * @action
 */
@Service
public class accountServiceImpl implements IAccountService {

    @Resource(name = "accountDaoImpl")
    private IAccountDao accountDao;

    @Autowired
    private TransactionManager utils;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        List<Account> accountList = accountDao.findAll();
        return accountList;
    }

    public Account findAccountById(int accountId) {
        Account account = accountDao.findAccountById(accountId);
        return account;
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(int accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void transfer(String sourceName, String targetName, double money) {
        try {
            //1.开启事务
            utils.startTransaction();
            //执行操作
            Account source = accountDao.findByName(sourceName);
            Account target = accountDao.findByName(targetName);
            source.setMoney(source.getMoney()-money);
            accountDao.updateAccount(source);
            int a = 1/0;
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(target);
            //2.提交事务
            utils.commitTransaction();
        } catch (Exception e) {
            utils.rollbackTransaction();
            e.printStackTrace();
        }finally {
            utils.release();
        }

    }
}
