package top.youngcoding.shiro.demo.ch03.util;

import org.junit.Before;
import org.junit.Test;

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
public class TokenUtilTest {

    @Before
    public void init() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("D:\\Documents and Settings\\60238\\Documents\\IdeaProjects\\shiro-demo\\shiro-ch03\\src\\main\\resources\\aes.properties")));
        AESUtil aesUtil =new AESUtil();
        aesUtil.setKey_seed(properties.getProperty("aes_key_seed"));
        aesUtil.init();

    }

    @Test
    public void token(){
            TokenUtil.passwordEncrypt("admin", "admin", "68E45C4D");
        TokenUtil.passwordEncrypt("tom", "123", "BC12A435");
        TokenUtil.passwordEncrypt("jerry", "321", "7AEAA0A4");
    }
}