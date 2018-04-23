package top.youngcoding.shiro.demo.ch03.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.util.ByteSource;

/**
 * @author liy
 * @date 2018/4/22
 */
public class TokenUtil {

    /**
     * 用户密码加密器，用于将前台用户输入的用户名、密码、盐加密为密文。
     * 加密方式为先md5再AES
     * @param username
     * @param password
     * @param salt
     * @return
     */
    public static String passwordEncrypt(String username, String password, ByteSource salt) {
        String src = username.toString() + (salt == null ? "" : salt.toString()) + password;

        String md5Crypt = DigestUtils.md5Hex(src);
//        System.out.println(Hex.encodeHexString(md5Crypt));
        String result = AESUtil.encrypt2Str(md5Crypt);
//        System.out.println(result);
        return result;
    }

}
