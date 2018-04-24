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
     *
     * @param username
     * @param password
     * @param salt
     * @return
     */
    public static String passwordEncrypt(String username, String password, ByteSource salt) {
        return passwordEncrypt(username, password, salt == null ? "" : salt.toString());
    }

    public static String passwordEncrypt(String username, String password, String salt) {
        String src = username + (salt == null ? "" : salt) + password;

        String md5Crypt = DigestUtils.md5Hex(src);
        md5Crypt = md5Crypt + salt;
        System.out.println(md5Crypt);
        String result = AESUtil.encrypt2Str(md5Crypt);
        System.out.println(result);
        return result;
    }

}
