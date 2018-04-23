package top.youngcoding.shiro.demo.ch03.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AES加解密工具类
 *
 * @author liy
 * @date 2018/4/20
 */
@Component
@PropertySource("classpath:aes.properties")
@Slf4j
public class AESUtil {
    private final static String DEFAULT_ENCODING = "UTF-8";
    public static final String SECURE_RANDOM_ALGORITHM = "SHA1PRNG";
    private final static String KEY_GENERATOR_ALGORITHM = "AES";
    private final static String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法
    // 加密种子
    private static byte[] key_seed = null;
    // AES加密的key
    private static SecretKey AES_KEY = null;

    @Value("${aes_key_seed}")
    public void setKey_seed(String key_seed_str) {
        log.debug("Load aes_key_seed_str from properties: {}", key_seed_str);
        AESUtil.key_seed = Base64.encodeBase64(StringUtils.getBytesUtf8(key_seed_str));
    }

    @PostConstruct
    public void init() {
        try {
            //密钥生成器
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_GENERATOR_ALGORITHM);
            // 根据种子生产强随机数
            SecureRandom secureRandom = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM);
            // AES 要求密钥长度为 128,192,256
            secureRandom.setSeed(key_seed);
            keyGenerator.init(128, secureRandom);
            // 生成密钥
            AES_KEY = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            log.error("不支持的加密算法。", e);
            e.printStackTrace();
        }
    }

    /**
     * 将源字符串src按默认字符集"utf-8"加密为byte数组
     *
     * @param src
     * @return
     */
    public static byte[] encrypt(String src) {
        return encrypt(src.getBytes(), AES_KEY, DEFAULT_CIPHER_ALGORITHM);
    }

    public static byte[] encrypt(byte[] src) {
        try {
            return encrypt(src, AES_KEY, DEFAULT_CIPHER_ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /**
     * 加密字符串到字符串(16进制字符串)
     *
     * @param src
     * @return
     */
    public static String encrypt2Str(String src) {
        try {
            return Hex.encodeHexString(encrypt(src.getBytes(), AES_KEY, DEFAULT_CIPHER_ALGORITHM));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static byte[] decrypt(String src) {
        try {
            byte[] bytes = Hex.decodeHex(src.toCharArray());

            return decrypt(bytes, AES_KEY, DEFAULT_CIPHER_ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public static byte[] decrypt(byte[] src) {
        try {
            return decrypt(src, AES_KEY, DEFAULT_CIPHER_ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public static String decrypt2Str(String src) {
        try {
            return new String(decrypt(src));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static byte[] encrypt(byte[] data, Key key, String cipherAlgorithm) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(cipherAlgorithm);
            //使用密钥初始化，设置为加密模式
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //执行操作
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }


    public static byte[] decrypt(byte[] data, Key key, String cipherAlgorithm) throws Exception {
        //实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, key);
        //执行操作
        return cipher.doFinal(data);
    }

}