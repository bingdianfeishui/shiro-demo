package top.youngcoding.shiro.demo.ch03.util;

import org.apache.commons.lang3.ClassPathUtils;
import org.apache.shiro.util.ByteSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.youngcoding.shiro.demo.ch03.config.MybatisConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * @author liy
 * @date 2018-4-24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AESUtil.class)
@ComponentScan(basePackages = "top.youngcoding.shiro.demo.ch03.util")
@PropertySource("classpath:aes.properties")
public class TokenUtilTest {

    @Value("${aes_key_seed}")
    private String aesKeySeed;

//    @Before
//    public void init() throws IOException {
//        AESUtil aesUtil = new AESUtil();
//        aesUtil.setKey_seed(aesKeySeed);
//        aesUtil.init();
//
//    }

    @Test
    public void token() {
        TokenUtil.passwordEncrypt("admin", "admin", ByteSource.Util.bytes("68E45C4D"));
        TokenUtil.passwordEncrypt("tom", "123", ByteSource.Util.bytes("BC12A435"));
        TokenUtil.passwordEncrypt("jerry", "123", ByteSource.Util.bytes("7AEAA0A4"));
    }
}