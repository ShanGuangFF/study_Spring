package com.xupt.ff.service.Impl;

import com.xupt.ff.dao.IAccountDao;
import com.xupt.ff.domain.Account;
import com.xupt.ff.service.IAccountService;

import java.util.List;

/**
 * @author cc_ff
 * @create 2019-11-20 下午5:56
 * @action
 */
public class accountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

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
}
