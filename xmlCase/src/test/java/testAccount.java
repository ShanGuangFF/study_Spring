import com.xupt.ff.domain.Account;
import com.xupt.ff.service.IAccountService;
import com.xupt.ff.service.Impl.accountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author cc_ff
 * @create 2019-11-20 下午7:06
 * @action
 */
public class testAccount {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");;
    private IAccountService accountService = ac.getBean("accountService", IAccountService.class);

    @Test
    public void testFindAll(){
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById(){
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("李姜丰");
        account.setMoney(5000);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setName("十初十遇");
        account.setMoney(100);
        account.setId(3);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete(){
        accountService.deleteAccount(3);
    }
}
