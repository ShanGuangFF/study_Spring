package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author cc_ff
 * @create 2019-11-20 下午10:38
 * @action
 */
public class jdbcConfig {

    @Bean(name = "Runner")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setUser("cc_ff");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/cc_ff");
            ds.setPassword("654321");
            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            return ds;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }

    }
}
