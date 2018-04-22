package top.youngcoding.shiro02.config;

import org.apache.shiro.authc.AbstractAuthenticator;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import top.youngcoding.shiro02.MyRealm;
import top.youngcoding.shiro02.RetryExceptionListener;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liy
 * @date 2018/4/20
 */
public class ShiroConfig {
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        factoryBean.setLoginUrl("/login");
        Map<String, String> map = new HashMap<>();
        map.put("/login","anon");
        map.put("/order/delete","perms[order:delete]");
        map.put("/**", "authc");
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(CacheManager cacheManager, MyRealm myRealm){
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(myRealm);
        webSecurityManager.setCacheManager(cacheManager);
        AbstractAuthenticator authenticator = (AbstractAuthenticator) webSecurityManager.getAuthenticator();
        authenticator.getAuthenticationListeners().add(new RetryExceptionListener());
        return webSecurityManager;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public MyRealm myRealm(RetryLimitAndAESCredentialsMatcher credentialsMatcher){
        MyRealm myRealm = new MyRealm();
        myRealm.setCachingEnabled(true);
        myRealm.setCredentialsMatcher(credentialsMatcher);
        myRealm.setAuthenticationCachingEnabled(true);
        myRealm.setAuthenticationCacheName("authenticationCache");
        myRealm.setAuthorizationCachingEnabled(true);
        myRealm.setAuthorizationCacheName("authorizationCache");
        return myRealm;
    }

    public EhCacheManagerFactoryBean ehCacheManagerFactory(){
        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
        factoryBean.setShared(true);
        factoryBean.setConfigLocation(new ClassPathResource("ehcache-shiro.xml"));
        factoryBean.afterPropertiesSet();
        return factoryBean;
    }

    @Bean
    public CacheManager cacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManager(ehCacheManagerFactory().getObject());
        return cacheManager;
    }

    @Bean
    public RetryLimitAndAESCredentialsMatcher retryLimitAndAESCredentialsMatcher(CacheManager cacheManager){
        return new RetryLimitAndAESCredentialsMatcher(cacheManager);
    }
}
