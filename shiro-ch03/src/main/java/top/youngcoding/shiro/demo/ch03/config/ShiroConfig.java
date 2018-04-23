package top.youngcoding.shiro.demo.ch03.config;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import top.youngcoding.shiro.demo.ch03.rbac.Ch03Realm;
import top.youngcoding.shiro.demo.ch03.rbac.RetryLimitAndAESCredentialsMatcher;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liy
 * @date 2018/4/23
 */
public class ShiroConfig {

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) throws Exception {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("/mainboard");
        factoryBean.setUnauthorizedUrl("/403");
        factoryBean.setSecurityManager(securityManager);

        Map<String, String> filterDefenitions = new LinkedHashMap<>();
        filterDefenitions.put("/index", "anon");
        filterDefenitions.put("/static/**", "anon");
        filterDefenitions.put("/js/**", "anon");
        filterDefenitions.put("/css/**", "anon");
        filterDefenitions.put("/**", "authc");
        filterDefenitions.put("/admin/**", "authc,roles[admin]");
        factoryBean.setFilterChainDefinitionMap(filterDefenitions);

        return factoryBean;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("ch03Realm") Realm realm, CacheManager cacheManager, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        securityManager.setCacheManager(cacheManager);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    @Bean
    public CacheManager cacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        cacheManager.init();
        return cacheManager;
    }

    @Bean
    public SessionManager sessionManager() {
        return new DefaultWebSessionManager();
    }

    @Bean("ch03Realm")
    public Realm Ch03Realm(RetryLimitAndAESCredentialsMatcher credentialsMatcher) {
        Ch03Realm Ch03Realm = new Ch03Realm();
        Ch03Realm.setCachingEnabled(true);
        Ch03Realm.setCredentialsMatcher(credentialsMatcher);
        Ch03Realm.setAuthenticationCachingEnabled(true);
        Ch03Realm.setAuthenticationCacheName("authenticationCache");
        Ch03Realm.setAuthorizationCachingEnabled(true);
        Ch03Realm.setAuthorizationCacheName("authorizationCache");
        return Ch03Realm;
    }

    @Bean
    public RetryLimitAndAESCredentialsMatcher retryLimitAndAESCredentialsMatcher(CacheManager cacheManager) {
        return new RetryLimitAndAESCredentialsMatcher(cacheManager);
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        return new AuthorizationAttributeSourceAdvisor();
    }

}
