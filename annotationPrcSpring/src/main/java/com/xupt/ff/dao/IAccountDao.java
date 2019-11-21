package com.xupt.ff.dao;

import com.xupt.ff.domain.Account;

import java.util.List;

/**
 * @author cc_ff
 * @create 2019-11-20 下午5:54
 * @action
 */
public interface IAccountDao {
    /**
     * @action 查询所有
     * @return 用户集合
     */
    List<Account> findAll();

    /**
     * @action 通过Id查询账户
     * @return
     */
    Account findAccountById(int accountId);

    /**
     * @action 保存用户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * @action 更新用户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * @action 根据id删除用户
     * @param accountId
     */
    void deleteAccount(int accountId);

    /**
     * @action 根据名称查询用户
     * @param name
     * @return
     */
    Account findByName(String name);

}
