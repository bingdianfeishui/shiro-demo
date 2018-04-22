package top.youngcoding.shiro02.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.ByteSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author liy
 * @date 2018/4/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppInitializer.class, WebMvcConfig.class, RootConfig.class})
public class RetryLimitAndAESCredentialsMatcherTest {

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void init() {
    }

    @Test
    public void doCredentialsMatch() {
        AuthenticationInfo info;
        AuthenticationToken token;
//        info = new SimpleAuthenticationInfo("admin", "3ef2774e11523e47da3a18d05ecd46dc9cdf84ae5189a3af5f7c32176398d26d", ByteSource.Util.bytes("salt"), "");
        info = new SimpleAuthenticationInfo("admin", "e3c2193d472110967cf67a53225b0eae9cdf84ae5189a3af5f7c32176398d26d","");
        token = new UsernamePasswordToken("admin", "123");

        RetryLimitAndAESCredentialsMatcher matcher = new RetryLimitAndAESCredentialsMatcher(cacheManager);
        System.out.println(matcher.doCredentialsMatch(token,info));
    }
}
