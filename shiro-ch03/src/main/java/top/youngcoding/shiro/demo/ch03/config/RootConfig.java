package top.youngcoding.shiro.demo.ch03.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @author liy
 * @date 2018/4/23
 */
@Configuration
@ComponentScan({"top.youngcoding.shiro.demo.**.service","top.youngcoding.shiro.demo.**.dao"})
@Import({MybatisConfig.class, ShiroConfig.class})
public class RootConfig {

}
