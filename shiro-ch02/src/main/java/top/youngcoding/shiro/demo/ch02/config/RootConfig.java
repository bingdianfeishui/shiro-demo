package top.youngcoding.shiro.demo.ch02.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author liy
 * @date 2018/4/20
 */
@Configuration
@Import({JdbcConfig.class, ShiroConfig.class})
public class RootConfig {
}
