package top.youngcoding.shiro.demo.ch02;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import top.youngcoding.shiro.demo.ch02.config.RootConfig;
import top.youngcoding.shiro.demo.ch02.config.WebAppInitializer;
import top.youngcoding.shiro.demo.ch02.config.WebMvcConfig;
import top.youngcoding.shiro.demo.ch02.util.AESUtil;

/**
 * @author liy
 * @date 2018/4/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppInitializer.class, WebMvcConfig.class, RootConfig.class})
public class AESUtilTest {

    @Autowired
    WebApplicationContext wac;

    private String src="adminMTIz123";
    //private String src="adminadmin";

    @Test
    public void init(){
        Object aesutil = wac.getBean("AESUtil");
        System.out.println(aesutil);
    }

    @Test
    public void encode() throws DecoderException {
        String md5Crypt = DigestUtils.md5Hex(this.src);
        System.out.println(md5Crypt);
        String dst1 = Hex.encodeHexString(AESUtil.encrypt(md5Crypt));
        String decode = AESUtil.decrypt2Str(dst1);
        System.out.println("加密后字符串："+dst1);
        System.out.println("解密完字符串："+decode);
        System.out.println(md5Crypt.equals(decode));
    }

}
