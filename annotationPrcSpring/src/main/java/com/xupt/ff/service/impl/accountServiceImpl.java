package com.xupt.ff.service.impl;

import com.xupt.ff.dao.IAccountDao;
import com.xupt.ff.dao.impl.accountDaoImpl;
import com.xupt.ff.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author cc_ff
 * @create 2019-11-19 下午9:46
 * @action
 */
@Component(value = "accountService")
public class accountServiceImpl implements IAccountService {

    @Resource(name = "accountDaoImpl")
    private IAccountDao accountDao ;


    public void saveAccount() {
        accountDao.saveAccount();
    }
}
