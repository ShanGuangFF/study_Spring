package com.xupt.ff.dao.impl;

import com.xupt.ff.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author cc_ff
 * @create 2019-11-19 下午10:07
 * @action
 */
@Repository
public class accountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存成功");
    }
}
