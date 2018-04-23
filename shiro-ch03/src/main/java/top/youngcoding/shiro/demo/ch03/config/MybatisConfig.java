package top.youngcoding.shiro.demo.ch03.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author liy
 * @date 2018/4/23
 */
@PropertySource(value = "classpath:jdbc.properties")
public class MybatisConfig {
    @Value("{jdbc.url}")
    private String url;
    @Value("{driverClassName}")
    private String driverClassName;
    @Value("{username}")
    private String username;
    @Value("{password}")
    private String password;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("top.youngcoding.shiro.demo.ch03.entity");

        SqlSessionFactory sqlSessionFactory = factoryBean.getObject();
        // 允许驼峰转换
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }
}
