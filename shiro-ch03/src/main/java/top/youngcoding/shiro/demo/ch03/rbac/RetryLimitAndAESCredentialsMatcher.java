package top.youngcoding.shiro.demo.ch03.rbac;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.ByteSource;
import top.youngcoding.shiro.demo.ch03.util.TokenUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 密码重试次数限制
 * @author liy
 * @date 2018/4/20
 */
public class RetryLimitAndAESCredentialsMatcher extends HashedCredentialsMatcher {
    private static final String DEFAULT_CACHE_KEY = "passwordRetryLimitCache";
    private static final String DEFAULT_CACHE_PREFIX = "passwordRetry:";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final int DEFAULT_MAX_RETRY_TIMES = 15;
    private Cache<String, AtomicInteger> passwordRetryLimitCache;

    public RetryLimitAndAESCredentialsMatcher(CacheManager cacheManager) {
        this(cacheManager, "md5");
    }

    public RetryLimitAndAESCredentialsMatcher(CacheManager cacheManager, String hashAlgorithmName) {
        super(hashAlgorithmName);
        this.passwordRetryLimitCache = cacheManager.getCache(DEFAULT_CACHE_KEY);
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String) token.getPrincipal();
        String cacheKey = DEFAULT_CACHE_PREFIX + username;
        AtomicInteger retryTimes = passwordRetryLimitCache.get(cacheKey);
        if (retryTimes == null) {
            passwordRetryLimitCache.put(cacheKey, new AtomicInteger(0));
        } else {

            int times = retryTimes.incrementAndGet();
            if (times > DEFAULT_MAX_RETRY_TIMES)
                throw new ExcessiveAttemptsException("超过最大重试次数" + DEFAULT_MAX_RETRY_TIMES + ", 请30分钟后重试！");
            //passwordRetryLimitCache.put(cacheKey, new AtomicInteger(times)); // 非本机内存缓存时用
        }
        // 验证
        String tokenHashedCredentials = getProvidedCredentials(token, info);
        String accountCredentials = getAccountCredentials(info);
//        System.out.println(Hex.encodeHexString((byte[]) tokenHashedCredentials));
//        System.out.println(Hex.encodeHexString((byte[]) accountCredentials));
        boolean result = equals(tokenHashedCredentials, accountCredentials);
        if (result)
            passwordRetryLimitCache.remove(cacheKey);
        return result;
    }

    /**
     * 获取数据库中查询出的凭证
     * @param info
     * @return
     */
    private String getAccountCredentials(AuthenticationInfo info) {
        Object credentials = info.getCredentials();
        return credentials.toString();
    }

    /**
     * 获取用户输入的凭证
     * @param token
     * @param info
     * @return
     */
    private String getProvidedCredentials(AuthenticationToken token, AuthenticationInfo info) {
        //先获取盐
        ByteSource salt = null;
        if (info instanceof SaltedAuthenticationInfo) {
            salt = ((SaltedAuthenticationInfo) info).getCredentialsSalt();
        }
        String principal = token.getPrincipal().toString();
        String credentials = new String((char[]) token.getCredentials());
        // 加密
        return TokenUtil.passwordEncrypt(principal, credentials, salt);
    }
}
