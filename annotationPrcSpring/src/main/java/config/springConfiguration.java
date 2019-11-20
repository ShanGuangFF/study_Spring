package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author cc_ff
 * @create 2019-11-20 下午9:38
 * @action 该类是一个配置类，它的作用和bean.xml是一样的
 */
@Configuration
@ComponentScan(basePackages = "com.xupt.ff")
@Import(jdbcConfig.class)
public class springConfiguration {
}
