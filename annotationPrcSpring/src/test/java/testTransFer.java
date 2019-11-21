import com.xupt.ff.domain.Account;
import com.xupt.ff.service.IAccountService;
import config.springConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author cc_ff
 * @create 2019-11-21 上午9:04
 * @action
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = springConfiguration.class)
public class testTransFer {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testTransFer(){
        accountService.transfer("简十初","简十遇",500);
    }
}
